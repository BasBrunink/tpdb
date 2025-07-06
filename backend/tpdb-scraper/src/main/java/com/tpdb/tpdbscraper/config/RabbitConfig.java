package com.tpdb.tpdbscraper.config;


import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    public static final String EXCHANGE_NAME = "tpdb.exchange";
    public static final String PARK_ROUTING_KEY = "tpdb.park.upsert";
    public static final String PAGELINK_ROUTING_KEY = "tpdb.pagelink.upsert";

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(EXCHANGE_NAME);
    }
}