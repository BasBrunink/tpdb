import { PartialType } from '@nestjs/mapped-types';
import { CreateResortAttractionDto } from './create-resort-attraction.dto';

export class UpdateResortAttractionDto extends PartialType(CreateResortAttractionDto) {}
