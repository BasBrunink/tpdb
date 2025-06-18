package com.tpdb.interfaceadapter.config;

import com.tpdb.application.service.ParkService;
import com.tpdb.application.service.types.*;
import com.tpdb.domain.port.ParkRepository;
import com.tpdb.domain.port.common.LocationRepository;
import com.tpdb.domain.port.types.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    @Bean
    public ParkService parkService(ParkRepository repository, ParkTypeRepository parkTypeRepository, LocationRepository locationRepository) {
        return new ParkService(repository, parkTypeRepository, locationRepository);
    }

    @Bean
    ParkTypeService parkTypeService(ParkTypeRepository repository){return new ParkTypeService(repository);}

    @Bean
    AccommodationTypeService accommodationTypeService(AccommodationTypeRepository repository) {
        return new AccommodationTypeService(repository);
    }

    @Bean
    CompanyTypeService companyTypeService(CompanyTypeRepository repository) {
        return new CompanyTypeService(repository);
    }

    @Bean
    ResortTypeService resortTypeService(ResortTypeRepository repository) {
        return new ResortTypeService(repository);
    }

    @Bean
    RestaurantTypeService restaurantTypeService(RestaurantTypeRepository repository) {
        return new RestaurantTypeService(repository);
    }
    @Bean
    RideTypeService rideTypeService(RideTypeRepository repository) {
        return new RideTypeService(repository);
    }

    @Bean
    ShopTypeService shopTypeService(ShopTypeRepository repository) {
        return new ShopTypeService(repository);
    }

    @Bean
    StatusTypeService statusTypeService(StatusTypeRepository repository) {
        return new StatusTypeService(repository);
    }


}
