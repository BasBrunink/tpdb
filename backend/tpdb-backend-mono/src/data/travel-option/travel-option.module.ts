import { Module } from '@nestjs/common';
import { TravelOptionService } from './travel-option.service';
import { TravelOptionController } from './travel-option.controller';
import { TypeOrmModule } from '@nestjs/typeorm';
import { TravelOption } from './entities/travel-option.entity';

@Module({
  imports: [TypeOrmModule.forFeature([TravelOption])],
  controllers: [TravelOptionController],
  providers: [TravelOptionService],
})
export class TravelOptionModule {}
