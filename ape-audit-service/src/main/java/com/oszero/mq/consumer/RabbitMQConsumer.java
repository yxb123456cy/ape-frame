package com.oszero.mq.consumer;


import com.alibaba.fastjson2.JSON;
import com.oszero.constants.MQConstants;
import com.oszero.entity.Note;
import com.oszero.service.TextAuditService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Slf4j
public class RabbitMQConsumer {
    @Resource
    private TextAuditService textAuditService;

    @RabbitListener(queues = {MQConstants.AUDIT_QUEUE})
    @RabbitHandler
    public void AuditQueueListener(Map<Long, String> message) {
        //Long 键为NoteID;
        log.info("rabbitmq消费消息 message:{}", message);
        textAuditService.textAuditByMap(message);
    }
}
