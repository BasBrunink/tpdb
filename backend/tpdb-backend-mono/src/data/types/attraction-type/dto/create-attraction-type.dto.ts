import { IsNotEmpty, IsString } from 'class-validator';

export class CreateAttractionTypeDto {
  @IsString()
  @IsNotEmpty()
  type: string;

  @IsString()
  description: string;

}
