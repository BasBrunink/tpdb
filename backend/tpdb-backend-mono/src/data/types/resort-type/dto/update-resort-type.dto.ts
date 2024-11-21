import { PartialType } from '@nestjs/mapped-types';
import { CreateResortTypeDto } from './create-resort-type.dto';

export class UpdateResortTypeDto extends PartialType(CreateResortTypeDto) {}
