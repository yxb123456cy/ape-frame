package com.oszero.config;

import com.oszero.constants.MQConstants;
import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    //配置Json序列化;
    @Bean
    public MessageConverter jacksonMessageConvertor() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public Exchange exchange() {
        return ExchangeBuilder
                .directExchange(MQConstants.AUDIT_EXCHANGE).build();
    }

    @Bean
    public Queue queue() {
        return new Queue(MQConstants.AUDIT_QUEUE, true);
    }
    @Bean
    public Binding binding(){
        return BindingBuilder.bind(queue())
                .to(exchange())
                .with(MQConstants.BINDING_KEY).noargs();
    }
}
