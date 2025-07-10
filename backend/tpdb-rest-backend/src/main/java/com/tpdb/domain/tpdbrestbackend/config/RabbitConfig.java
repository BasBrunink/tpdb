package com.tpdb.domain.tpdbrestbackend.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitConfig {

    public static final String EXCHANGE_NAME = "tpdb.exchange";

    public static final String PARK_ROUTING_KEY = "tpdb.park.upsert";
    public static final String PAGELINK_ROUTING_KEY = "tpdb.pagelink.upsert";
    public static final String PAGELINK_REQUEST_ROUTING_KEY = "tpdb.pagelink.request";
    public static final String PAGELINK_FETCH_ROUTING_KEY = "tpdb.pagelink.fetch";
    public static final String PAGELINK_UPDATE_ROUTING_KEY = "tpdb.pagelink.update";
    public static final String PAGELINK_DELETE_ROUTING_KEY = "tpdb.pagelink.delete";

    public static final String PARK_QUEUE_NAME = "tpdb.park.queue";
    public static final String PAGELINK_QUEUE_NAME = "tpdb.pagelink.queue";
    public static final String PAGELINK_REQUEST_QUEUE_NAME = "tpdb.pagelink.request.queue";
    public static final String PAGELINK_FETCH_QUEUE_NAME = "tpdb.pagelink.fetch.queue";
    public static final String PAGELINK_UPDATE_QUEUE_NAME = "tpdb.pagelink.update.queue";
    public static final String PAGELINK_DELETE_QUEUE_NAME = "tpdb.pagelink.delete.queue";


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
    public Queue pageLinkRequestQueue() {
        return new Queue(PAGELINK_REQUEST_QUEUE_NAME);
    }
    @Bean
    public Queue pageLinkFetchQueue() {
        return new Queue(PAGELINK_FETCH_QUEUE_NAME);
    }

    @Bean
    public Queue pageLinkUpdateQueue() {
        return new Queue(PAGELINK_UPDATE_QUEUE_NAME);
    }

    @Bean
    public Queue pageLinkDeleteQueue() {return new Queue(PAGELINK_DELETE_QUEUE_NAME);}
    @Bean
    public Binding pageLinkUpdateBinding(@Qualifier("pageLinkUpdateQueue") Queue queue, TopicExchange exchange) {
        return BindingBuilder
                .bind(queue)
                .to(exchange)
                .with(PAGELINK_UPDATE_ROUTING_KEY);
    }
    @Bean
    public Binding pageLinkDeleteBinding(@Qualifier("pageLinkDeleteQueue") Queue queue, TopicExchange exchange) {
        return BindingBuilder
                .bind(queue)
                .to(exchange)
                .with(PAGELINK_DELETE_ROUTING_KEY);
    }
    @Bean
    public Binding pageLinkRequestBinding(@Qualifier("pageLinkRequestQueue") Queue queue, TopicExchange exchange) {
        return BindingBuilder
                .bind(queue)
                .to(exchange)
                .with(PAGELINK_REQUEST_ROUTING_KEY);
    }
    @Bean
    public Binding pageLinkFetchBinding(@Qualifier("pageLinkFetchQueue") Queue queue, TopicExchange exchange) {
        return BindingBuilder
                .bind(queue)
                .to(exchange)
                .with(PAGELINK_FETCH_ROUTING_KEY);
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