import { IsNotEmpty, IsString } from 'class-validator';

export class CreateParkTypeDto {
  @IsString()
  @IsNotEmpty()
  type: string;

  @IsString()
  description: string;
}
