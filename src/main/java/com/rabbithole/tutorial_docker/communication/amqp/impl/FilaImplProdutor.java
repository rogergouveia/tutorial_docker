package com.rabbithole.tutorial_docker.communication.amqp.impl;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.rabbithole.tutorial_docker.communication.amqp.FilaConfigurations;
import com.rabbithole.tutorial_docker.communication.amqp.FilaProdutor;

@Profile("Producer")
@Component
public class FilaImplProdutor implements FilaProdutor{

    @Autowired
    private RabbitTemplate rabbitTemplate;
    
    @Autowired
    private FilaConfigurations filaConfigurations;
    
    @Override
    public void send(Object message) {
        rabbitTemplate.convertAndSend(filaConfigurations.getTopicExchangeName(), 
                                      filaConfigurations.getRoutingKey(), 
                                      message );
    }
    

}
