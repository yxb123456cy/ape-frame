package com.oszero.mq.producer;

import com.oszero.service.TextAuditService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafKaProducer {
    @Resource
    private TextAuditService textAuditService;
}
