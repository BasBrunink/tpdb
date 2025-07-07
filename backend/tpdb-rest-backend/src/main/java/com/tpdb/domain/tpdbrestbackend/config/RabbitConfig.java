package com.tpdb.domain.tpdbrestbackend.config;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitConfig {

    public static final String EXCHANGE_NAME = "tpdb.exchange";
    public static final String PARK_ROUTING_KEY = "tpdb.park.upsert";
    public static final String PARK_QUEUE_NAME = "tpdb.park.queue";
    public static final String PAGELINK_ROUTING_KEY = "tpdb.pagelink.upsert";
    public static final String PAGELINK_QUEUE_NAME = "tpdb.pagelink.queue";


    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(EXCHANGE_NAME);
    }

    @Bean
    public Queue parkQueue() {
        return new Queue(PARK_QUEUE_NAME);
    }

    @Bean
    public Binding parkBinding(@Qualifier("parkQueue")Queue queue, TopicExchange exchange) {
        return BindingBuilder
                .bind(queue)
                .to(exchange)
                .with(PARK_ROUTING_KEY);
    }

    @Bean
    public Queue pageLinkQueue() {
        return new Queue(PAGELINK_QUEUE_NAME);
    }

    @Bean
    public Binding pagelinkBinding(@Qualifier("pageLinkQueue") Queue queue, TopicExchange exchange) {
        return BindingBuilder
                .bind(queue)
                .to(exchange)
                .with(PAGELINK_ROUTING_KEY);
    }
}