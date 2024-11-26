import { Module } from '@nestjs/common';
import { EntryFeeService } from './entry-fee.service';
import { EntryFeeController } from './entry-fee.controller';

@Module({
  controllers: [EntryFeeController],
  providers: [EntryFeeService],
})
export class EntryFeeModule {}
