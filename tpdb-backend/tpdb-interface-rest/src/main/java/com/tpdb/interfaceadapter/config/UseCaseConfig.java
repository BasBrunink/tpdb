package com.tpdb.interfaceadapter.config;

import com.tpdb.application.port.in.data.ParkUseCase;
import com.tpdb.application.port.in.data.types.*;
import com.tpdb.application.service.ParkService;
import com.tpdb.application.service.types.*;
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


    @Bean
    AccommodationTypeUseCase accommodationTypeUseCase(AccommodationTypeService accommodationTypeService) {
        return accommodationTypeService;}

    @Bean
    CompanyTypeUseCase companyTypeUseCase(CompanyTypeService companyTypeService) {
        return companyTypeService;
    }

    @Bean
    ResortTypeUseCase resortTypeUseCase(ResortTypeService service) {
        return service;
    }

    @Bean
    RestaurantTypeUseCase restaurantTypeUseCase(RestaurantTypeService service) {
        return service;
    }

    @Bean
    RideTypeUseCase rideTypeUseCase(RideTypeService service) {
        return service;
    }

    @Bean
    ShopTypeUseCase shopTypeUseCase(ShopTypeService service) {
        return service;
    }

    @Bean
    StatusTypeUseCase statusTypeUseCase(StatusTypeService service) {
        return service;
    }

}
