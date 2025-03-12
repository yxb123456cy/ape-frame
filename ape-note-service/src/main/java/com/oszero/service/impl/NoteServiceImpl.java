package com.oszero.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.oszero.entity.Note;
import com.oszero.mapper.NoteMapper;
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
public class NoteServiceImpl extends ServiceImpl<NoteMapper, Note>
    implements NoteService {
    private final NoteMapper mapper;
}




