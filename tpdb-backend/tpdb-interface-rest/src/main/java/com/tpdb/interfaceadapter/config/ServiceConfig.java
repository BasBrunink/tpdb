package com.tpdb.interfaceadapter.config;

import com.tpdb.application.service.ParkService;
import com.tpdb.application.service.types.AccommodationTypeService;
import com.tpdb.application.service.types.ParkTypeService;
import com.tpdb.domain.port.ParkRepository;
import com.tpdb.domain.port.types.AccommodationTypeRepository;
import com.tpdb.domain.port.types.ParkTypeRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    @Bean
    public ParkService parkService(ParkRepository repository, ParkTypeRepository parkTypeRepository) {
        return new ParkService(repository, parkTypeRepository);
    }

    @Bean
    ParkTypeService parkTypeService(ParkTypeRepository repository){return new ParkTypeService(repository);}

    @Bean
    AccommodationTypeService accommodationTypeService(AccommodationTypeRepository repository) {
        return new AccommodationTypeService(repository);
    }
}
