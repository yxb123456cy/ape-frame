package com.oszero.constants;

public interface MQConstants {

    //rabbitmq相关;
    String AUDIT_EXCHANGE = "ape.audit.exchange";
    String AUDIT_QUEUE = "ape.audit.queue";
    String BINDING_KEY = "fjx.audit";


    //kafka相关;
    String AUDIT_TOPIC = "audit.topic";


}
