import { Module } from '@nestjs/common';
import { TravelOptionService } from './travel-option.service';
import { TravelOptionController } from './travel-option.controller';

@Module({
  controllers: [TravelOptionController],
  providers: [TravelOptionService],
})
export class TravelOptionModule {}
