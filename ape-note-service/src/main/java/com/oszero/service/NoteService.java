package com.oszero.service;

import com.oszero.entity.Note;
import com.baomidou.mybatisplus.extension.service.IService;
import com.oszero.pojo.dto.NotePublishDTO;
import com.oszero.response.Response;

/**
* @author Administrator
* @description 针对表【note(笔记记录表)】的数据库操作Service
* @createDate 2025-03-12 13:58:51
*/
public interface NoteService extends IService<Note> {

    Response<Boolean> publish(NotePublishDTO notePublishDTO);
}
