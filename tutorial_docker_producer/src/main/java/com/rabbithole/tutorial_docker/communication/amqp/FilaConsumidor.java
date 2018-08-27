package com.rabbithole.tutorial_docker.communication.amqp;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;

public interface FilaConsumidor {
    public SimpleMessageListenerContainer container(ConnectionFactory connectionFactory);
    public void consumir(Object message);
}
