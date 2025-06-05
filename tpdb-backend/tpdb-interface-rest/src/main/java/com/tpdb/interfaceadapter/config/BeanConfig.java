package com.tpdb.interfaceadapter.config;

import com.tpdb.application.port.in.data.ParkUseCase;
import com.tpdb.application.port.in.data.types.parktype.ParkTypeUseCase;
import com.tpdb.application.service.ParkService;
import com.tpdb.application.service.types.ParkTypeService;
import com.tpdb.domain.port.types.ParkTypeRepository;
import com.tpdb.infrastructure.repository.adapter.ParkRepositoryAdapter;
import com.tpdb.infrastructure.repository.adapter.types.ParkTypeRepositoryAdapter;
import com.tpdb.infrastructure.repository.jpa.JpaParkRepository;
import com.tpdb.domain.port.ParkRepository;
import com.tpdb.infrastructure.repository.jpa.types.JpaParkTypeRepository;
import com.tpdb.infrastructure.repository.mapper.ParkInfraStructureMapper;
import com.tpdb.infrastructure.repository.mapper.types.ParkTypeInfraStrucureMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {


    @Bean
    public ParkRepository parkRepository(JpaParkRepository parkRepo, ParkInfraStructureMapper parkInfraStructureMapper, ParkTypeInfraStrucureMapper parkTypeInfraStrucureMapper) {
        return new ParkRepositoryAdapter(parkRepo, parkInfraStructureMapper, parkTypeInfraStrucureMapper);
    }

    @Bean
    public ParkTypeRepository parkTypeRepository(JpaParkTypeRepository jpaRepo, ParkTypeInfraStrucureMapper parkTypeInfraStrucureMapper){return new ParkTypeRepositoryAdapter(jpaRepo, parkTypeInfraStrucureMapper);
    }

    @Bean
    public ParkService parkService(ParkRepository repository, ParkTypeRepository parkTypeRepository) {
        return new ParkService(repository, parkTypeRepository);
    }

    @Bean ParkTypeService parkTypeService(ParkTypeRepository repository){return new ParkTypeService(repository);}

    @Bean
    public ParkUseCase parkUseCase(ParkService parkService) {
        return parkService;
    }

    @Bean
    public ParkTypeUseCase parkTypeUseCase(ParkTypeService parkTypeService){return parkTypeService;}
}
