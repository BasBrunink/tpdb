package com.tpdb.tpdbrestbackend;

import com.tpdb.tpdbrestbackend.config.RabbitConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
@RequiredArgsConstructor
public class TpdbRestBackendApplication implements CommandLineRunner {


    public static void main(String[] args) {
        SpringApplication.run(TpdbRestBackendApplication.class, args);
    }

    private final RabbitAdmin rabbitAdmin;
    @Override
    public void run(String... args) {

        rabbitAdmin.purgeQueue(RabbitConfig.PARK_QUEUE_NAME);
        rabbitAdmin.purgeQueue(RabbitConfig.PAGELINK_QUEUE_NAME);
        rabbitAdmin.purgeQueue(RabbitConfig.PAGELINK_FETCH_QUEUE_NAME);
        rabbitAdmin.purgeQueue(RabbitConfig.PAGELINK_REQUEST_QUEUE_NAME);
        rabbitAdmin.purgeQueue(RabbitConfig.PAGELINK_UPDATE_QUEUE_NAME);
        rabbitAdmin.purgeQueue(RabbitConfig.PAGELINK_DELETE_QUEUE_NAME);

    }
}
