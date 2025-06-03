package com.tpdb.interfaceadapter.config;

import com.tpdb.application.port.in.CreateParkUseCase;
import com.tpdb.application.port.in.ListParksUseCase;
import com.tpdb.application.service.ParkService;
import com.tpdb.infrastructure.repository.adapter.ParkRepositoryAdapter;
import com.tpdb.infrastructure.repository.jpa.JpaParkRepository;
import com.tpdb.domain.port.ParkRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {


    @Bean
    public ParkRepository parkRepository(JpaParkRepository jpaRepo) {
        return new ParkRepositoryAdapter(jpaRepo);
    }

    @Bean
    public ParkService parkService(ParkRepository repository) {
        return new ParkService(repository);
    }

    @Bean
    public CreateParkUseCase createParkUseCase(ParkService parkService) {
        return parkService;
    }

    @Bean
    public ListParksUseCase listParksUseCase(ParkService parkService) {
        return parkService;
    }
}
