import { Injectable } from '@nestjs/common';
import { CreateResortDto } from './dto/create-resort.dto';
import { UpdateResortDto } from './dto/update-resort.dto';

@Injectable()
export class ResortService {
  create(createResortDto: CreateResortDto) {
    return 'This action adds a new resort';
  }

  findAll() {
    return `This action returns all resort`;
  }

  findOne(id: number) {
    return `This action returns a #${id} resort`;
  }

  update(id: number, updateResortDto: UpdateResortDto) {
    return `This action updates a #${id} resort`;
  }

  remove(id: number) {
    return `This action removes a #${id} resort`;
  }
}
