import { PartialType } from '@nestjs/mapped-types';
import { CreateTravelOptionDto } from './create-travel-option.dto';

export class UpdateTravelOptionDto extends PartialType(CreateTravelOptionDto) {}
