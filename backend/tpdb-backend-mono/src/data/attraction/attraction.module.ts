import { Module } from '@nestjs/common';
import { AttractionService } from './attraction.service';
import { AttractionController } from './attraction.controller';
import { TypeOrmModule } from '@nestjs/typeorm';
import { Attraction } from './entities/attraction.entity';
import { AttractionTypeModule } from './attraction-type/attraction-type.module';

@Module({
  imports: [TypeOrmModule.forFeature([Attraction]), AttractionTypeModule],
  controllers: [AttractionController],
  providers: [AttractionService],
})
export class AttractionModule {}
