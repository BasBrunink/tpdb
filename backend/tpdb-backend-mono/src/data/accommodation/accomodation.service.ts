import { Injectable } from '@nestjs/common';
import { CreateAccommodationDto } from './dto/create-accommodation.dto';
import { UpdateAccommodationDto } from './dto/update-accommodation.dto';

@Injectable()
export class AccomodationService {
  create(createAccomodationDto: CreateAccommodationDto) {
    return 'This action adds a new accomodation';
  }

  findAll() {
    return `This action returns all accomodation`;
  }

  findOne(id: number) {
    return `This action returns a #${id} accomodation`;
  }

  update(id: number, updateAccomodationDto: UpdateAccommodationDto) {
    return `This action updates a #${id} accomodation`;
  }

  remove(id: number) {
    return `This action removes a #${id} accomodation`;
  }
}
