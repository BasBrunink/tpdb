import { Injectable } from '@nestjs/common';
import { CreateTravelOptionDto } from './dto/create-travel-option.dto';
import { UpdateTravelOptionDto } from './dto/update-travel-option.dto';

@Injectable()
export class TravelOptionService {
  create(createTravelOptionDto: CreateTravelOptionDto) {
    return 'This action adds a new travelOption';
  }

  findAll() {
    return `This action returns all travelOption`;
  }

  findOne(id: number) {
    return `This action returns a #${id} travelOption`;
  }

  update(id: number, updateTravelOptionDto: UpdateTravelOptionDto) {
    return `This action updates a #${id} travelOption`;
  }

  remove(id: number) {
    return `This action removes a #${id} travelOption`;
  }
}
