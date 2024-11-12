import { Injectable } from '@nestjs/common';
import { CreateAccomodationAmenityDto } from './dto/create-accomodation-amenity.dto';
import { UpdateAccomodationAmenityDto } from './dto/update-accomodation-amenity.dto';

@Injectable()
export class AccomodationAmenitiesService {
  create(createAccomodationAmenityDto: CreateAccomodationAmenityDto) {
    return 'This action adds a new accomodationAmenity';
  }

  findAll() {
    return `This action returns all accomodationAmenities`;
  }

  findOne(id: number) {
    return `This action returns a #${id} accomodationAmenity`;
  }

  update(id: number, updateAccomodationAmenityDto: UpdateAccomodationAmenityDto) {
    return `This action updates a #${id} accomodationAmenity`;
  }

  remove(id: number) {
    return `This action removes a #${id} accomodationAmenity`;
  }
}
