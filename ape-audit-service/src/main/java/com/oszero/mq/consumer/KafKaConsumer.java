package com.oszero.mq.consumer;

import com.alibaba.fastjson2.JSON;
import com.oszero.constants.MQConstants;
import com.oszero.entity.Note;
import com.oszero.service.TextAuditService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafKaConsumer {
    @Resource
    private  TextAuditService textAuditService;

    @KafkaListener(topics ={MQConstants.AUDIT_TOPIC})
    public void listener(ConsumerRecord<String, Object> consumerRecord) {
        try {
            Object value = consumerRecord.value();
            Note note = JSON.parseObject(value.toString(), Note.class);
            log.info("kafka消费消息 value:{}", note);
            log.info("开始进行文本审核");
            textAuditService.textAudit(note);
        } catch (Exception e) {
            log.error("kafKa消费异常:{}", e.getMessage());
        }

    }

}
