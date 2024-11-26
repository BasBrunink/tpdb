import { Module } from '@nestjs/common';
import { AttractionTypeService } from './attraction-type.service';
import { AttractionTypeController } from './attraction-type.controller';

@Module({
  controllers: [AttractionTypeController],
  providers: [AttractionTypeService],
})
export class AttractionTypeModule {}
