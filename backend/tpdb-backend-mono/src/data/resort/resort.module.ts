import { Module } from '@nestjs/common';
import { ResortService } from './resort.service';
import { ResortController } from './resort.controller';

@Module({
  controllers: [ResortController],
  providers: [ResortService],
})
export class ResortModule {}
