import {
  ConflictException,
  HttpException,
  HttpStatus,
  Injectable,
  NotFoundException,
} from '@nestjs/common';
import { CreateParkTypeDto } from './dto/create-park-type.dto';
import { UpdateParkTypeDto } from './dto/update-park-type.dto';
import { InjectRepository } from '@nestjs/typeorm';
import { ParkType } from './entities/park-type.entity';
import { Repository } from 'typeorm';
import { PostgresErrorCode } from '../../../database/postgresErrorCodes.enum';
import { ParktypeResponse } from './dto/parktype-response.dto';
import { User } from '../../../authentication/user/entities/user.entity';

@Injectable()
export class ParkTypeService {
  constructor(
    @InjectRepository(ParkType)
    private readonly repo: Repository<ParkType>,
  ) {}

  create(createParkTypeDto: CreateParkTypeDto, user: User) {
    console.log(user);
    try {
      const parkType: ParkType = {
        name: createParkTypeDto.name,
        description: createParkTypeDto.description,
        createdAt: new Date(),
        createdBy: user,
        updatedBy: user,
        updatedAt: new Date(),
      };
      const typeToSave = this.repo.create(parkType);
      return this.repo.save(typeToSave);
    } catch (error) {
      if (error.code === PostgresErrorCode.UniqueValidation) {
        throw new ConflictException('ParkType already exists');
      }
      throw new HttpException(
        `Error creating ParkType: ${error.message}`,
        HttpStatus.INTERNAL_SERVER_ERROR,
      );
    }
  }

  async findAll(): Promise<ParktypeResponse[]> {
    const res: ParktypeResponse[] = await this.repo.find();
    if (res.length === 0) {
      throw new NotFoundException(
        `No ParkTypes found. Ensure the migration has run.`,
      );
    }
    return res;
  }

  async findOne(id: string) {
    const res = await this.repo.findOneBy({ id });

    if (!res) {
      throw new NotFoundException(`Parktype with ID ${id} is not found`);
    }
    return res;
  }

  async update(
    id: string,
    updateParkTypeDto: UpdateParkTypeDto,
  ): Promise<ParkType> {
    const parkType = await this.repo.findOneBy({ id });
    if (!parkType) {
      throw new NotFoundException(`ParkType with ID ${id} not found`);
    }
    Object.assign(parkType, updateParkTypeDto);
    parkType.updatedAt = new Date();
    try {
      return await this.repo.save(parkType);
    } catch (error) {
      if (error.code === PostgresErrorCode.UniqueValidation) {
        throw new ConflictException('Park typ already exists');
      }
      throw new HttpException(
        `Error updating ParkType: ${error.message}`,
        HttpStatus.INTERNAL_SERVER_ERROR,
      );
    }
  }

  async remove(id: string) {
    const result = await this.repo.delete(id);
    if (result.affected === 0) {
      throw new NotFoundException(`ParkType with ID ${id} not found`);
    }
  }
}
