package com.back;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class inP14510Application {

    public static void main(String[] args) {
        SpringApplication.run(inP14510Application.class, args);
    }

}
