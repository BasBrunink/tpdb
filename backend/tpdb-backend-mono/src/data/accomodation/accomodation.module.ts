import { Module } from '@nestjs/common';
import { AccomodationService } from './accomodation.service';
import { AccomodationController } from './accomodation.controller';
import { AccomodationAmenitiesModule } from './accomodation-amenities/accomodation-amenities.module';

@Module({
  controllers: [AccomodationController],
  providers: [AccomodationService],
  imports: [AccomodationAmenitiesModule],
})
export class AccomodationModule {}
