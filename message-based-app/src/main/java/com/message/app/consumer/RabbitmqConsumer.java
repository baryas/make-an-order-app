//package com.message.app.consumer;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.stereotype.Service;
//
//@Service
//public class RabbitmqConsumer {
//
//    private static final Logger LOGGER =
//            LoggerFactory.getLogger(RabbitmqConsumer.class);
//
//
//    @RabbitListener(queues = {"queue_a"})
//    public void consumeMessage(String message){
//    LOGGER.info(String.format("message subscribed --> %s", message));
//    }
//
//}
