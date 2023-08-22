package com.message.app.config;

import com.rabbitmq.client.AMQP;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitmqConfig {

//    @Value("${rabbitmq.queue.name}")
//    private String queue;
//
//    @Value("${rabbitmq.exchange.name}")
//    private String exchange;
//
//    @Value("${rabbitmq.routingKey.name}")
//    private String routingKey;

    @Bean
    public Queue queue(){

        return new Queue("queue_a");
    }

    @Bean
    public TopicExchange exchange(){

        return new TopicExchange("exchange_a");
    }

    @Bean
    public Binding binding(){
        return BindingBuilder
                .bind(queue())
                .to(exchange())
                .with("routingKey_a");
    }


}
