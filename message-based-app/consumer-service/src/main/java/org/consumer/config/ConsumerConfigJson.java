package org.consumer.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConsumerConfigJson {

    @Bean
    public Queue queueJson(){

        return new Queue("queue_b");
    }

    @Bean
    public TopicExchange exchangeJson(){
        return new TopicExchange("exchange_b");
    }

    @Bean
    public Binding bindingJson(){
        return BindingBuilder
                .bind(queueJson())
                .to(exchangeJson())
                .with("routingKey2");

    }

    @Bean
    public Jackson2JsonMessageConverter converter(){

        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(converter());
        return rabbitTemplate;
    }


}
