import { IsNotEmpty, IsString } from 'class-validator';

export class CreateResortTypeDto {
  @IsString()
  @IsNotEmpty()
  type: string;

  @IsString()
  description: string;
}
