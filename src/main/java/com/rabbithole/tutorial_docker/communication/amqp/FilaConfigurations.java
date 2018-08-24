package com.rabbithole.tutorial_docker.communication.amqp;

public interface FilaConfigurations {

    public String getTopicExchangeName();

    public void setTopicExchangeName(String topicExchangeName);

    public String getQueueName();

    public void setQueueName(String queueName);

    public String getRoutingKey();

    public void setRoutingKey(String routingKey);
    
}
