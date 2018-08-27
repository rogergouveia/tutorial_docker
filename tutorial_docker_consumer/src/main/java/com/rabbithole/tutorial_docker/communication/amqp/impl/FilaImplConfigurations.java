package com.rabbithole.tutorial_docker.communication.amqp.impl;

import javax.validation.constraints.NotBlank;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import com.rabbithole.tutorial_docker.communication.amqp.FilaConfigurations;

@Configuration
@ConfigurationProperties(prefix = "tutorial-docker.fila")
@Validated
public class FilaImplConfigurations implements FilaConfigurations{
    
    @NotBlank
    private String topicExchangeName;

    @NotBlank
    private String queueName;
    
    @NotBlank
    private String routingKey;

    @Override
    public String getTopicExchangeName() {
        return topicExchangeName;
    }

    @Override
    public void setTopicExchangeName(String topicExchangeName) {
        this.topicExchangeName = topicExchangeName;
    }

    @Override
    public String getQueueName() {
        return queueName;
    }

    @Override
    public void setQueueName(String queueName) {
        this.queueName = queueName;
    }

    @Override
    public String getRoutingKey() {
        return routingKey;
    }

    @Override
    public void setRoutingKey(String routingKey) {
        this.routingKey = routingKey;
    }

}
