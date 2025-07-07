package com.tpdb.domain.tpdbrestbackend.consumers;

import com.tpdb.domain.data.Park;
import com.tpdb.domain.internal.comunication.dto.ParkDto;
import com.tpdb.domain.tpdbrestbackend.config.RabbitConfig;
import com.tpdb.domain.tpdbrestbackend.services.usercases.ParkUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ParkConsumer {

    private final ParkUseCase parkService;
    @RabbitListener(queues = RabbitConfig.PARK_QUEUE_NAME)
    public void handleMessage(ParkDto request) {
        log.info("Received park: {}", request.name());
        Park park = Park.builder()
                .name(request.name())
                .description(request.description())
                .parkType(request.parkType())
                .opening(request.opening())
                .closing(request.closing())
                .status(request.status())
                .address(request.address())
                .areaSize(request.areaSize())
                .build();
        parkService.create(park);
    }
}
