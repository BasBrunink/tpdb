package com.tpdb.interfaceadapter.config;

import com.tpdb.domain.port.ParkRepository;
import com.tpdb.domain.port.types.*;
import com.tpdb.infrastructure.repository.adapter.ParkRepositoryAdapter;
import com.tpdb.infrastructure.repository.adapter.types.*;
import com.tpdb.infrastructure.repository.jpa.JpaParkRepository;
import com.tpdb.infrastructure.repository.jpa.types.*;
import com.tpdb.infrastructure.repository.mapper.ParkEntityMapper;
import com.tpdb.infrastructure.repository.mapper.types.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepoConfig {

    @Bean
    public ParkRepository parkRepository(JpaParkRepository parkRepo, ParkEntityMapper parkEntityMapper, ParkTypeEntityMapper parkTypeEntityMapper) {
        return new ParkRepositoryAdapter(parkRepo, parkEntityMapper, parkTypeEntityMapper);
    }
    @Bean
    public ParkTypeRepository parkTypeRepository(JpaParkTypeRepository jpaRepo, ParkTypeEntityMapper parkTypeEntityMapper){
        return new ParkTypeRepositoryAdapter(jpaRepo, parkTypeEntityMapper);
    }

    @Bean
    public AccommodationTypeRepository accommodationTypeRepository(JpaAccommodationTypeRepository jpaRepo, AccommodationTypeEntityMapper mapper){
        return new AccommodationTypeRepositoryAdapter(jpaRepo, mapper);
    }

    @Bean
    public CompanyTypeRepository companyTypeRepository(JpaCompanyTypeRepository jpaRepo, CompanyTypeEntityMapper mapper){
        return new CompanyTypeRepositoryAdapter(jpaRepo, mapper);
    }

    @Bean
    public ResortTypeRepository resortTypeRepository(JpaResortTypeRepository jpaRepo, ResortTypeEntityMapper mapper){
        return new ResortTypeRepositoryAdapter(jpaRepo, mapper);
    }

    @Bean
    public RestaurantTypeRepository restaurantTypeRepository(JpaRestaurantTypeRepository jpaRepo, RestaurantTypeEntityMapper mapper){
        return new RestaurantTypeRepositoryAdapter(jpaRepo, mapper);
    }

    @Bean
    public RideTypeRepository rideTypeRepository(JpaRideTypeRepository jpaRepo, RideTypeEntityMapper mapper){
        return new RideTypeRepositoryAdapter(jpaRepo, mapper);
    }

    @Bean
    public ShopTypeRepository shopTypeRepository(JpaShopTypeRepository jpaRepo, ShopTypeEntityMapper mapper){
        return new ShopTypeRepositoryAdapter(jpaRepo, mapper);
    }

    @Bean
    public StatusTypeRepository statusTypeRepository(JpaStatusTypeRepository jpaRepo, StatusTypeEntityMapper mapper){
        return new StatusTypeRepositoryAdapter(jpaRepo, mapper);
    }
}
