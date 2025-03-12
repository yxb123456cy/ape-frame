package com.oszero.service;

import com.oszero.entity.Note;

import java.util.Map;

public interface TextAuditService {
    void textAudit(Note note);

    void textAuditByMap(Map<Long, String> message);


}
