//package com.message.app.consumer;
//
//import com.message.app.dto.Order;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.stereotype.Service;
//
//@Service
//public class JsonConsumer {
//
//    private static final Logger LOGGER = LoggerFactory.getLogger(JsonConsumer.class);
//
//    @RabbitListener(queues = {"queue_b"})
//    public void consumeJsonMessage(Order order){
//        LOGGER.info(String.format("Subscribed JSON -> %s", order.toString()));
//    }
//
//}
