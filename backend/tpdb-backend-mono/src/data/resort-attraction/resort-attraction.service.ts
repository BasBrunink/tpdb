import { Injectable } from '@nestjs/common';
import { CreateResortAttractionDto } from './dto/create-resort-attraction.dto';
import { UpdateResortAttractionDto } from './dto/update-resort-attraction.dto';

@Injectable()
export class ResortAttractionService {
  create(createResortAttractionDto: CreateResortAttractionDto) {
    return 'This action adds a new resortAttraction';
  }

  findAll() {
    return `This action returns all resortAttraction`;
  }

  findOne(id: number) {
    return `This action returns a #${id} resortAttraction`;
  }

  update(id: number, updateResortAttractionDto: UpdateResortAttractionDto) {
    return `This action updates a #${id} resortAttraction`;
  }

  remove(id: number) {
    return `This action removes a #${id} resortAttraction`;
  }
}
