package com.tpdb.domain.tpdbrestbackend;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class TpdbRestBackendApplication {


    public static void main(String[] args) {
        SpringApplication.run(TpdbRestBackendApplication.class, args);
    }

}
