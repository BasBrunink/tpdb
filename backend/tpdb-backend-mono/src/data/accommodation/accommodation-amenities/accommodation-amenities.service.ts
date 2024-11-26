import { Injectable } from '@nestjs/common';
import { CreateAccommodationAmenityDto } from './dto/create-accommodation-amenity.dto';
import { UpdateAccommodationAmenityDto } from './dto/update-accommodation-amenity.dto';

@Injectable()
export class AccommodationAmenitiesService {
  create(createAccomodationAmenityDto: CreateAccommodationAmenityDto) {
    return 'This action adds a new accomodationAmenity';
  }

  findAll() {
    return `This action returns all accomodationAmenities`;
  }

  findOne(id: number) {
    return `This action returns a #${id} accomodationAmenity`;
  }

  update(
    id: number,
    updateAccomodationAmenityDto: UpdateAccommodationAmenityDto,
  ) {
    return `This action updates a #${id} accomodationAmenity`;
  }

  remove(id: number) {
    return `This action removes a #${id} accomodationAmenity`;
  }
}
