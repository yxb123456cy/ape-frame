package com.oszero.service.impl;

import com.oszero.service.NoteService;
import com.oszero.service.NoteStatusService;
import com.oszero.service.TextAuditService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class TextAuditServiceImpl implements TextAuditService {
    private final NoteService noteService;
    private final NoteStatusService noteStatusService;
}
