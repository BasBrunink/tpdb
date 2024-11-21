import { PartialType } from '@nestjs/mapped-types';
import { CreateAccomodationTypeDto } from './create-accomodation-type.dto';

export class UpdateAccomodationTypeDto extends PartialType(
  CreateAccomodationTypeDto,
) {}
