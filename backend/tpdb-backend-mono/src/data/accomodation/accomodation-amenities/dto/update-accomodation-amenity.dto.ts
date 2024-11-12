import { PartialType } from '@nestjs/mapped-types';
import { CreateAccomodationAmenityDto } from './create-accomodation-amenity.dto';

export class UpdateAccomodationAmenityDto extends PartialType(CreateAccomodationAmenityDto) {}
