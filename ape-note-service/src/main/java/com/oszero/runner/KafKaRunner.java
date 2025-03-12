package com.oszero.runner;

import com.oszero.constants.MQConstants;
import jakarta.annotation.Resource;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafKaRunner implements ApplicationRunner {
    @Resource
    private KafkaTemplate<Object, Object> kafkaTemplate;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        kafkaTemplate.send(MQConstants.AUDIT_TOPIC, "hello,world");
    }
}
