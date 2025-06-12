package com.tpdb.interfaceadapter.config;

import com.tpdb.application.port.in.data.ParkUseCase;
import com.tpdb.application.port.in.data.types.ParkTypeUseCase;
import com.tpdb.application.service.ParkService;
import com.tpdb.application.service.types.ParkTypeService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean
    public ParkUseCase parkUseCase(ParkService parkService) {
        return parkService;
    }

    @Bean
    public ParkTypeUseCase parkTypeUseCase(ParkTypeService parkTypeService){return parkTypeService;}

}
