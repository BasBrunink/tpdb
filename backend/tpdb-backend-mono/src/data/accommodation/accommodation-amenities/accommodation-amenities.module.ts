import { Module } from '@nestjs/common';
import { AccommodationAmenitiesService } from './accommodation-amenities.service';
import { AccommodationAmenitiesController } from './accommodation-amenities.controller';
import { TypeOrmModule } from '@nestjs/typeorm';
import { AccommodationAmenity } from './entities/accommodation-amenity.entity';

@Module({
  imports: [TypeOrmModule.forFeature([AccommodationAmenity])],
  controllers: [AccommodationAmenitiesController],
  providers: [AccommodationAmenitiesService],
})
export class AccommodationAmenitiesModule {}
