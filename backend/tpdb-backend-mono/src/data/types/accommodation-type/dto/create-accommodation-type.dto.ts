import { IsNotEmpty, IsString } from 'class-validator';

export class CreateAccommodationTypeDto {
  @IsString()
  @IsNotEmpty()
  type: string;

  @IsString()
  description: string;
}
