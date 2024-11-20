import { Module } from '@nestjs/common';
import { ResortTypeService } from './resort-type.service';
import { ResortTypeController } from './resort-type.controller';

@Module({
  controllers: [ResortTypeController],
  providers: [ResortTypeService],
})
export class ResortTypeModule {}
