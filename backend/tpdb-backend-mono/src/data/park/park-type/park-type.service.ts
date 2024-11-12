import { Injectable } from '@nestjs/common';
import { CreateParkTypeDto } from './dto/create-park-type.dto';
import { UpdateParkTypeDto } from './dto/update-park-type.dto';

@Injectable()
export class ParkTypeService {
  create(createParkTypeDto: CreateParkTypeDto) {
    return 'This action adds a new parkType';
  }

  findAll() {
    return `This action returns all parkType`;
  }

  findOne(id: number) {
    return `This action returns a #${id} parkType`;
  }

  update(id: number, updateParkTypeDto: UpdateParkTypeDto) {
    return `This action updates a #${id} parkType`;
  }

  remove(id: number) {
    return `This action removes a #${id} parkType`;
  }
}
