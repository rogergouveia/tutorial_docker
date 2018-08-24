package com.rabbithole.tutorial_docker.communication.amqp.impl;

import org.springframework.stereotype.Component;


@Component
public class FilaImplConsumidor //implements FilaConsumidor
{
//
//    private RequisicaoAcionamento requisicao;
//    
//    private SimpleMessageListenerContainer container;
//    
//    @Qualifier("requisicaoAcionamento")
//    @Autowired
//    private FilaConfigurations filaConfigurations;
//    
//    @PostConstruct
//    public void init() {
//        container = new SimpleMessageListenerContainer();
//        container.setMessageListener(new MessageListenerAdapter(this, "consumir"));
//    }
//
//    @Override
//    public void consumir(Object message) {
//        System.out.println("mensagem recebida...");
//        if (message instanceof RequisicaoAcionamentoDto) {
//            System.out.println("...conversao com sucesso");
//            requisicao = (RequisicaoAcionamento)requisicao;
//            
//        }
//        else {
//            System.out.println("...conversao falhou");
//        }
//    }
//    
//    @Bean
//    @Qualifier("requisicaoAcionamento")
//    @Override
//    public SimpleMessageListenerContainer container(ConnectionFactory connectionFactory) {
//        container.setConnectionFactory(connectionFactory);
//        container.setQueueNames(filaConfigurations.getQueueName());
//        return container;
//    }

}
