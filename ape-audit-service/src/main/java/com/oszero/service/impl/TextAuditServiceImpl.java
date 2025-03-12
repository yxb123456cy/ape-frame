package com.oszero.service.impl;


import cn.hutool.core.util.IdUtil;
import com.github.houbb.sensitive.word.core.SensitiveWordHelper;
import com.oszero.entity.Note;
import com.oszero.entity.NoteStatus;
import com.oszero.service.NoteStatusService;
import com.oszero.service.TextAuditService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
@RequiredArgsConstructor
public class TextAuditServiceImpl implements TextAuditService {

    private final NoteStatusService noteStatusService;

    /**
     * kafka消费者
     * @param note note
     */
    @Override
    public void textAudit(Note note) {

    }

    /**
     * rabbitmq消费者
     * @param message map
     */
    @Override
    public void textAuditByMap(Map<Long, String> message) {
        Set<Map.Entry<Long, String>> entries = message.entrySet();
        Long noteID = null;
        String content = "";
        for (Map.Entry<Long, String> entry : entries) {
            noteID = entry.getKey();
            content = entry.getValue();
        }
        boolean contains = SensitiveWordHelper.contains(content);
        log.info("审核完成,结果为===>{}", contains ? "包含敏感词" : "不包含敏感词");
        log.info("触发了下列敏感词");
        List<String> wordList = SensitiveWordHelper.findAll(content);
        log.info(Arrays.toString(wordList.toArray()));
        //保存至数据库;
        NoteStatus noteStatus = NoteStatus.builder()
                .id(IdUtil.getSnowflakeNextId())
                .status(contains ? 0 : 1)
                .noteId(noteID)
                .build();
        this.saveToDB(noteStatus);
        //封装消息再传送至note-service进行websocket通知;
        this.sendAuditMessage("rabbit",noteID,contains);

    }

    //
    private boolean saveToDB(NoteStatus noteStatus) {
        return noteStatusService.save(noteStatus);
    }

    //消息转发;
    private void sendAuditMessage(String MQType, Long noteID, boolean status) {
        //status为true代表不通过 为false则通过
    }
}
