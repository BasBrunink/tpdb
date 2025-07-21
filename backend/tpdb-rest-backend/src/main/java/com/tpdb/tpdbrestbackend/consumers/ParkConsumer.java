package com.tpdb.tpdbrestbackend.consumers;

import com.tpdb.domain.data.Park;
import com.tpdb.domain.internal.comunication.dto.ParkDto;
import com.tpdb.tpdbrestbackend.config.RabbitConfig;
import com.tpdb.tpdbrestbackend.services.usercases.ParkUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ParkConsumer {

    private final ParkUseCase parkService;
    @RabbitListener(queues = RabbitConfig.PARK_QUEUE_NAME)
    public void handleMessage(ParkDto request) {
        Optional<Park> existingPark = parkService.findBySourceAndSourceId(request.source(), request.sourceId());

        if(existingPark.isPresent()) {
            log.info("Park already exists: {}", request.sourceId() );
            return;
        }
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
                .source(request.source())
                .sourceId(request.sourceId())
                .build();
        parkService.create(park);
    }
}
