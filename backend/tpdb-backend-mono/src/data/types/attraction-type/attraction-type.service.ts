import { Injectable } from '@nestjs/common';
import { CreateAttractionTypeDto } from './dto/create-attraction-type.dto';
import { UpdateAttractionTypeDto } from './dto/update-attraction-type.dto';

@Injectable()
export class AttractionTypeService {
  create(createAttractionTypeDto: CreateAttractionTypeDto) {
    return 'This action adds a new attractionType';
  }

  findAll() {
    return `This action returns all attractionType`;
  }

  findOne(id: number) {
    return `This action returns a #${id} attractionType`;
  }

  update(id: number, updateAttractionTypeDto: UpdateAttractionTypeDto) {
    return `This action updates a #${id} attractionType`;
  }

  remove(id: number) {
    return `This action removes a #${id} attractionType`;
  }
}
