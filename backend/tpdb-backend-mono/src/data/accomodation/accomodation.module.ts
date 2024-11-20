import { Module } from '@nestjs/common';
import { AccomodationService } from './accomodation.service';
import { AccomodationController } from './accomodation.controller';
import { AccomodationAmenitiesModule } from './accomodation-amenities/accomodation-amenities.module';
import { TypeOrmModule } from '@nestjs/typeorm';
import { Accomodation } from './entities/accomodation.entity';

@Module({
  controllers: [AccomodationController],
  providers: [AccomodationService],
  imports: [
    TypeOrmModule.forFeature([Accomodation]),
    AccomodationAmenitiesModule,
  ],
})
export class AccomodationModule {}
