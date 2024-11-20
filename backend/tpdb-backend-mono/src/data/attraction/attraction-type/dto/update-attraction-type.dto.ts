import { PartialType } from '@nestjs/mapped-types';
import { CreateAttractionTypeDto } from './create-attraction-type.dto';

export class UpdateAttractionTypeDto extends PartialType(CreateAttractionTypeDto) {}
