package com.oszero.runner;

import com.alibaba.fastjson2.JSON;
import com.oszero.constants.MQConstants;
import com.oszero.entity.Note;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KafKaRunner implements ApplicationRunner {
    @Resource
    private KafkaTemplate<Object, Object> kafkaTemplate;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        //向default-topic发送消息; sendDefault
        Note note = Note.builder().userId(1L).content("javaee").id(100L).build();
        SendResult<Object, Object> sendResult = kafkaTemplate.sendDefault(JSON.toJSONString(note)).join();
        RecordMetadata recordMetadata = sendResult.getRecordMetadata();
        String topic = recordMetadata.topic();
        int partition = recordMetadata.partition();
        log.info("topic:{},partition:{}", topic, partition);
    }
}
