import { PartialType } from '@nestjs/mapped-types';
import { CreateResortInternalTransportationDto } from './create-resort-internal-transportation.dto';

export class UpdateResortInternalTransportationDto extends PartialType(CreateResortInternalTransportationDto) {}
