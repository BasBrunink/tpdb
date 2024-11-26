import { PartialType } from '@nestjs/mapped-types';
import { CreateAccommodationAmenityDto } from './create-accommodation-amenity.dto';

export class UpdateAccommodationAmenityDto extends PartialType(
  CreateAccommodationAmenityDto,
) {}
