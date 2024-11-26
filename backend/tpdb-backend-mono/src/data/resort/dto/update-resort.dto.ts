import { PartialType } from '@nestjs/mapped-types';
import { Resort } from '../entities/resort.entity';
import { CreateResortDto } from './create-resort.dto';

export class UpdateResortDto extends PartialType(CreateResortDto) {}
