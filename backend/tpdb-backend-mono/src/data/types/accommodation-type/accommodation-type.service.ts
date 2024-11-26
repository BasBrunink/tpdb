import { Injectable } from '@nestjs/common';
import { CreateAccommodationTypeDto } from './dto/create-accommodation-type.dto';
import { UpdateAccommodationTypeDto } from './dto/update-accommodation-type.dto';

@Injectable()
export class AccommodationTypeService {
  create(createAccomodationTypeDto: CreateAccommodationTypeDto) {
    return 'This action adds a new accomodationType';
  }

  findAll() {
    return `This action returns all accomodationType`;
  }

  findOne(id: number) {
    return `This action returns a #${id} accomodationType`;
  }

  update(id: number, updateAccomodationTypeDto: UpdateAccommodationTypeDto) {
    return `This action updates a #${id} accomodationType`;
  }

  remove(id: number) {
    return `This action removes a #${id} accomodationType`;
  }
}
