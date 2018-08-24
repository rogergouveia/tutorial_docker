package com.rabbithole.tutorial_docker.communication.amqp.impl;

import javax.annotation.PostConstruct;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.rabbithole.tutorial_docker.communication.amqp.FilaConfigurations;
import com.rabbithole.tutorial_docker.communication.amqp.FilaConsumidor;
import com.rabbithole.tutorial_docker.data.Order;
import com.rabbithole.tutorial_docker.data.OrderRepository;

@Profile("Consumer")
@Component
public class FilaImplConsumidor implements FilaConsumidor{

    private SimpleMessageListenerContainer container;
    private OrderRepository orderRepo;
    
    @Autowired
    private FilaConfigurations filaConfigurations;
    
    @PostConstruct
    public void init() {
        container = new SimpleMessageListenerContainer();
        container.setMessageListener(new MessageListenerAdapter(this, "consumir"));
    }

    @Override
    public void consumir(Object message) {
        System.out.println("mensagem recebida...");
        if (message instanceof Order) {
            System.out.println("...conversao com sucesso");
            Order order = (Order)message;
            orderRepo.save(order);
            System.out.println("Salva order: "+order.toString());
            
        }
        else {
            System.out.println("deu pau no consumo da fila :(");
        }
    }
    
    @Bean
    @Override
    public SimpleMessageListenerContainer container(ConnectionFactory connectionFactory) {
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(filaConfigurations.getQueueName());
        return container;
    }

}
