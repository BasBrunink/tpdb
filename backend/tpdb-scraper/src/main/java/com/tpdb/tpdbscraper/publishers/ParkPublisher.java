package com.tpdb.tpdbscraper.publishers;

import com.tpdb.domain.internal.comunication.dto.ParkDto;
import com.tpdb.tpdbscraper.config.RabbitConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ParkPublisher {

    private final RabbitTemplate rabbitTemplate;

    public void sendPark(ParkDto park) {
        rabbitTemplate.convertAndSend(
                RabbitConfig.EXCHANGE_NAME,
                RabbitConfig.PARK_ROUTING_KEY,
                park
        );

    }


}