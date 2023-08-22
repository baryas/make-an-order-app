package com.message.app.publisher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitmqPublisher {

//    @Value("${rabbitmq.exchange.name}")
//    private String exchange;
//
//    @Value("${rabbitmq.routingKey.name}")
//    private String routingKey;

    private RabbitTemplate rabbitTemplate;

    public RabbitmqPublisher(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate = rabbitTemplate;
    }

    private static final Logger LOGGER =
            LoggerFactory.getLogger(RabbitmqPublisher.class);

    public void sendMessage(String message){
        rabbitTemplate.convertAndSend("exchange_a", "routingKey_a", message);
        LOGGER.info(String.format("message sent -> %s", message));
    }

}
