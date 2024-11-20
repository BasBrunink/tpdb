import { Module } from '@nestjs/common';
import { ResortAttractionService } from './resort-attraction.service';
import { ResortAttractionController } from './resort-attraction.controller';

@Module({
  controllers: [ResortAttractionController],
  providers: [ResortAttractionService],
})
export class ResortAttractionModule {}
