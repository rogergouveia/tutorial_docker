package com.rabbithole.tutorial_docker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.rabbithole.tutorial_docker.communication.amqp.FilaProdutor;
import com.rabbithole.tutorial_docker.data.Item;

@Component
public class Producer {
    
    @Autowired
    private FilaProdutor fila;
    
    private Long counter=0l;
    
    @Scheduled(fixedRate=15000)
    public void postarNaFila() {
        String produto = "PRODUTO"+counter;
        Item order = new Item();
        order.setCodigo(counter);
        order.setProduto(produto);
        order.setQuantidade(counter);
        System.out.println(produto+":POSTANDO NA FILA...");
        try {
            fila.send(order);
            System.out.println(produto+":POSTADO :)");
        }catch(RuntimeException e) {
            System.out.println(produto+":nao funfou postar na fila :(");
        }
        
        counter++;
    }
}
