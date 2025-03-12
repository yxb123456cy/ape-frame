
package com.oszero.config;

import com.alibaba.fastjson2.JSON;
import com.oszero.constants.MQConstants;
import com.oszero.entity.Note;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafKaConfig {
    @KafkaListener(topics = MQConstants.AUDIT_TOPIC)
    public void listener(ConsumerRecord<String, Object> consumerRecord) {
        try {
            Object value = consumerRecord.value();
            Note note = JSON.parseObject(value.toString(), Note.class);
            log.info("kafka消费消息 value:{}", note);
        } catch (Exception e) {
            log.error("kafKa消费异常:{}", e.getMessage());
        }

    }
}
