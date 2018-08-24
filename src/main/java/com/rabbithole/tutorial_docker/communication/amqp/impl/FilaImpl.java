package com.rabbithole.tutorial_docker.communication.amqp.impl;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.rabbithole.tutorial_docker.communication.amqp.Fila;
import com.rabbithole.tutorial_docker.communication.amqp.FilaConfigurations;



@Component
@Qualifier("requisicaoAcionamento")
public class FilaImpl implements Fila{
    
    @Qualifier("requisicaoAcionamento")
    @Autowired
    private FilaConfigurations filaConfigurations;

    @Bean
    @Qualifier("requisicaoAcionamento")
    @Override
    public Queue queue() {
        return new Queue(filaConfigurations.getQueueName(), false);
    }

    @Bean
    @Qualifier("requisicaoAcionamento")
    @Override
    public TopicExchange topicExchange() {
        return new TopicExchange(filaConfigurations.getTopicExchangeName());
    }

    @Bean
    @Qualifier("requisicaoAcionamento")
    @Override
    public Binding binding(@Qualifier("requisicaoAcionamento")Queue queue, 
                           @Qualifier("requisicaoAcionamento")TopicExchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with(filaConfigurations.getRoutingKey());
    }

}
