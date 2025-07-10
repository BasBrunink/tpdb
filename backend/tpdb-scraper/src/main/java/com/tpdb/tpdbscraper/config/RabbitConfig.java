package com.tpdb.tpdbscraper.config;


import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    public static final String EXCHANGE_NAME = "tpdb.exchange";

    public static final String PARK_ROUTING_KEY = "tpdb.park.upsert";
    public static final String PAGELINK_ROUTING_KEY = "tpdb.pagelink.upsert";
    public static final String PAGELINK_UPDATE_ROUTINGKEY = "tpdb.pagelink.update";
    public static final String PAGELINK_REQUEST_ROUTING_KEY = "tpdb.pagelink.request";
    public static final String PAGELINK_DELETE_ROUTINGKEY = "tpdb.pagelink.delete";

    public static final String PAGELINK_FETCH_QUEUE_NAME = "tpdb.pagelink.fetch.queue";


    @Bean
    public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory) {
        RabbitAdmin admin = new RabbitAdmin(connectionFactory);
        admin.setAutoStartup(true);
        return admin;
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(EXCHANGE_NAME);
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(jsonMessageConverter());
        return template;
    }
}