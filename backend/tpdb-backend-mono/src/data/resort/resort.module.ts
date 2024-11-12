import { Module } from '@nestjs/common';
import { ResortService } from './resort.service';
import { ResortController } from './resort.controller';
import { TypeOrmModule } from '@nestjs/typeorm';
import { Resort } from './entities/resort.entity';

@Module({
  imports: [TypeOrmModule.forFeature([Resort])],
  controllers: [ResortController],
  providers: [ResortService],
})
export class ResortModule {}
