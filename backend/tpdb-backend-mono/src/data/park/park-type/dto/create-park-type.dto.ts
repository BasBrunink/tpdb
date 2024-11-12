import { IsNotEmpty, IsString } from 'class-validator';

export class CreateParkTypeDto {

    @IsString()
    @IsNotEmpty()
    name: string;

    @IsString()
    description: string;
}
