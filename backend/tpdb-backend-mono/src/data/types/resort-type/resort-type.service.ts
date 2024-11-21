import { Injectable } from '@nestjs/common';
import { CreateResortTypeDto } from './dto/create-resort-type.dto';
import { UpdateResortTypeDto } from './dto/update-resort-type.dto';

@Injectable()
export class ResortTypeService {
  create(createResortTypeDto: CreateResortTypeDto) {
    return 'This action adds a new resortType';
  }

  findAll() {
    return `This action returns all resortType`;
  }

  findOne(id: number) {
    return `This action returns a #${id} resortType`;
  }

  update(id: number, updateResortTypeDto: UpdateResortTypeDto) {
    return `This action updates a #${id} resortType`;
  }

  remove(id: number) {
    return `This action removes a #${id} resortType`;
  }
}
