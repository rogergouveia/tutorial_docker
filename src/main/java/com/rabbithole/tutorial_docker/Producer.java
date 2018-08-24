package com.rabbithole.tutorial_docker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.rabbithole.tutorial_docker.communication.amqp.FilaProdutor;
import com.rabbithole.tutorial_docker.data.Order;

@Profile("Producer")
@Component
public class Producer {
    @Autowired
    private FilaProdutor fila;
    
    private Long counter=0l;
    
    @Scheduled(fixedRate=5000)
    public void postarNaFila() {
        Order order = new Order();
        order.setCodigo(counter);
        order.setProduto("produto"+counter);
        order.setQuantidade(counter);
        try {
            fila.send(order);
        }catch(RuntimeException e) {
            System.out.println("nao funfou postar na fila :(");
        }
        
        counter++;
    }
}
