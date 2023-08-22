package org.consumer.consumer;

import org.consumer.dto.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerJson {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerJson.class);

    @RabbitListener(queues = {"queue_b"})
    public void consumeJsonMessage(Order order){
        LOGGER.info(String.format("Order subscribed -> %s", order ));
    }
}
