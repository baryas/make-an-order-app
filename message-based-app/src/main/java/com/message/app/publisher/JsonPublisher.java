package com.message.app.publisher;

import com.message.app.dto.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class JsonPublisher {

    private RabbitTemplate rabbitTemplate;

     public JsonPublisher(RabbitTemplate rabbitTemplate){

         this.rabbitTemplate = rabbitTemplate;
     }


     private static final Logger LOGGER =
             LoggerFactory.getLogger(JsonPublisher.class);

     public void sendJsonMessage(Order order){
         LOGGER.info(String.format("order sent -> %s", order.toString()));
         rabbitTemplate.convertAndSend("exchange_b","routingKey2",order);
     }


}
