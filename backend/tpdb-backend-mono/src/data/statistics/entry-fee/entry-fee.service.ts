import { Injectable } from '@nestjs/common';
import { CreateEntryFeeDto } from './dto/create-entry-fee.dto';
import { UpdateEntryFeeDto } from './dto/update-entry-fee.dto';

@Injectable()
export class EntryFeeService {
  create(createEntryFeeDto: CreateEntryFeeDto) {
    return 'This action adds a new entryFee';
  }

  findAll() {
    return `This action returns all entryFee`;
  }

  findOne(id: number) {
    return `This action returns a #${id} entryFee`;
  }

  update(id: number, updateEntryFeeDto: UpdateEntryFeeDto) {
    return `This action updates a #${id} entryFee`;
  }

  remove(id: number) {
    return `This action removes a #${id} entryFee`;
  }
}
