package com.rabbithole.tutorial_docker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class TutorialDockerApplication //implements ApplicationRunner
{
    public static void main(String[] args) {
        SpringApplication.run(TutorialDockerApplication.class, args);
    }
    
//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//      System.in.read();
//    }
}
