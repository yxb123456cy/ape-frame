package com.oszero.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oszero.entity.NoteStatus;
import com.oszero.service.NoteStatusService;
import com.oszero.mapper.NoteStatusMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【note_status(笔记审核记录表)】的数据库操作Service实现
* @createDate 2025-03-12 13:58:51
*/
@Service
@Slf4j
@RequiredArgsConstructor
public class NoteStatusServiceImpl extends ServiceImpl<NoteStatusMapper, NoteStatus>
    implements NoteStatusService{
    private final NoteStatusMapper mapper;

}




