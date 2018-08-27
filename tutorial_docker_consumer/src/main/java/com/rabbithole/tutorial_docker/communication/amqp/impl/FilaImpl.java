package com.rabbithole.tutorial_docker.communication.amqp.impl;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.rabbithole.tutorial_docker.communication.amqp.Fila;
import com.rabbithole.tutorial_docker.communication.amqp.FilaConfigurations;



@Component
public class FilaImpl implements Fila{
    
    @Autowired
    private FilaConfigurations filaConfigurations;

    @Bean
    @Override
    public Queue queue() {
        return new Queue(filaConfigurations.getQueueName(), true);
    }

    @Bean
    @Override
    public TopicExchange topicExchange() {
        return new TopicExchange(filaConfigurations.getTopicExchangeName());
    }

    @Bean
    @Override
    public Binding binding(Queue queue,TopicExchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with(filaConfigurations.getRoutingKey());
    }

}
