package com.oszero.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.oszero.domain.User;
import com.oszero.domain.UserFindDTO;
import com.oszero.entity.Note;
import com.oszero.enums.ResponseCodeEnum;
import com.oszero.exception.BizException;
import com.oszero.mapper.NoteMapper;
import com.oszero.pojo.dto.NotePublishDTO;
import com.oszero.response.Response;
import com.oszero.rpc.UserFeignAPi;
import com.oszero.service.NoteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author Administrator
 * @description 针对表【note(笔记记录表)】的数据库操作Service实现
 * @createDate 2025-03-12 13:58:51
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class NoteServiceImpl extends ServiceImpl<NoteMapper, Note> implements NoteService {
    private final NoteMapper mapper;
    private final UserFeignAPi userFeignAPi;

    //根据UserID获取User;
    private User getUser(long id) {
        UserFindDTO userFindDTO = new UserFindDTO();
        userFindDTO.setId(id);
        Response<com.oszero.domain.User> response = userFeignAPi.getByID(userFindDTO);
        if (response != null && response.isSuccess() && response.getData() != null) {
            return response.getData();
        }
        return null;
    }

    @Override
    public Response<Boolean> publish(NotePublishDTO notePublishDTO) {
        Long userId = notePublishDTO.getUserId();
        User user = this.getUser(userId);
        if (user == null) {
            //user为null;
            throw new BizException(ResponseCodeEnum.USER_NOT_EXISTS);
        }
        //user存在;
        Note note = Note.builder()
                .userId(userId)
                .content(notePublishDTO.getContent())
                .build();
        boolean saved = save(note);
        if (!saved) {
            throw new BizException(ResponseCodeEnum.NOTE_PUBLISH_ERROR);
        }
        log.info("笔记发布成功 userID:{} content:{}", userId, notePublishDTO.getContent());
        //todo 消息队列转发;
        //kafka
        //rabbitmq;
        return Response.success(true);
    }
}




