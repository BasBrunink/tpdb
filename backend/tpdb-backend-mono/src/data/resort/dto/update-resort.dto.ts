import { PartialType } from '@nestjs/mapped-types';
import { Resort } from '../entities/resort.entity';

export class UpdateResortDto extends PartialType(Resort) {}
