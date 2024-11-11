import { Module } from '@nestjs/common';
import { ResortModule } from './resort/resort.module';

@Module({
  imports: [ResortModule]
})
export class DataModule {}
