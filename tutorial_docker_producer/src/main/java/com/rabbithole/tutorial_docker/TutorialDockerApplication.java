package com.rabbithole.tutorial_docker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
public class TutorialDockerApplication //implements ApplicationRunner
{
    public static void main(String[] args) {
        SpringApplication.run(TutorialDockerApplication.class, args);
    }
    
//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//      System.in.read();
//    }
    
//  @Bean
//  public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
//      return args -> {
//
//          System.out.println("Let's inspect the beans provided by Spring Boot:");
//
//          String[] beanNames = ctx.getBeanDefinitionNames();
//          Arrays.sort(beanNames);
//          for (String beanName : beanNames) {
//              System.out.println(beanName);
//          }
//      };
//  }
}
