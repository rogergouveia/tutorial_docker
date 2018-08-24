package com.rabbithole.tutorial_docker;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TutorialController {
    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }
}
