import { PartialType } from '@nestjs/mapped-types';
import { CreateParkTypeDto } from './create-park-type.dto';

export class UpdateParkTypeDto extends PartialType(CreateParkTypeDto) {}
