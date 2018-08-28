package com.rabbithole.tutorial_docker.communication.amqp.impl;

import javax.annotation.PostConstruct;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.rabbithole.tutorial_docker.communication.amqp.FilaConfigurations;
import com.rabbithole.tutorial_docker.communication.amqp.FilaConsumidor;
import com.rabbithole.tutorial_docker.data.Item;
import com.rabbithole.tutorial_docker.data.ItemRepository;

@Component
public class FilaImplConsumidor implements FilaConsumidor{

    private SimpleMessageListenerContainer container;
    
    @Autowired
    private ItemRepository orderRepo;
    
    @Autowired
    private FilaConfigurations filaConfigurations;
    
    @PostConstruct
    public void init() {
        container = new SimpleMessageListenerContainer();
        container.setMessageListener(new MessageListenerAdapter(this, "consumir"));
    }

    @Override
    public void consumir(Object message) {
        
        System.out.println("MENSAGEM NA FILA...");
        if (message instanceof Item) {
            Item order = (Item)message;
            System.out.println(order.getProduto()+":RECEBIDO");
            orderRepo.save(order);
            System.out.println(order.getProduto()+":SALVO NO BD");
//            try {
//                Thread.sleep(30000);
//            } catch (InterruptedException e) {
//                System.out.println("("+id+")deu pau no sleeeep :(");
//            }
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
