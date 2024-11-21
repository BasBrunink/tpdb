import { PartialType } from '@nestjs/mapped-types';
import { CreateResortEventDto } from './create-resort-event.dto';

export class UpdateResortEventDto extends PartialType(CreateResortEventDto) {}
