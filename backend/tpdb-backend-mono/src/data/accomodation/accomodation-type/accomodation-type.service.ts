import { Injectable } from '@nestjs/common';
import { CreateAccomodationTypeDto } from './dto/create-accomodation-type.dto';
import { UpdateAccomodationTypeDto } from './dto/update-accomodation-type.dto';

@Injectable()
export class AccomodationTypeService {
  create(createAccomodationTypeDto: CreateAccomodationTypeDto) {
    return 'This action adds a new accomodationType';
  }

  findAll() {
    return `This action returns all accomodationType`;
  }

  findOne(id: number) {
    return `This action returns a #${id} accomodationType`;
  }

  update(id: number, updateAccomodationTypeDto: UpdateAccomodationTypeDto) {
    return `This action updates a #${id} accomodationType`;
  }

  remove(id: number) {
    return `This action removes a #${id} accomodationType`;
  }
}
