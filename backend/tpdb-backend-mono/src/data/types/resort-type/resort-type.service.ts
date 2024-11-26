import { ConflictException, HttpException, HttpStatus, Injectable, NotFoundException } from '@nestjs/common';
import { CreateResortTypeDto } from './dto/create-resort-type.dto';
import { UpdateResortTypeDto } from './dto/update-resort-type.dto';
import { InjectRepository } from '@nestjs/typeorm';
import { ResortType } from './entities/resort-type.entity';
import { Repository } from 'typeorm';
import { User } from '../../../authentication/user/entities/user.entity';
import { PostgresErrorCode } from '../../../database/postgresErrorCodes.enum';

class ResortTypeResponse {
}

@Injectable()
export class ResortTypeService {

  constructor(
    @InjectRepository(ResortType)
    private readonly repo: Repository<ResortType>,
  ) {
  }

  create(createResortTypeDto: CreateResortTypeDto, user: User) {
    try {
      const resortType: ResortType = {
        type: createResortTypeDto.type,
        description: createResortTypeDto.description,
        createdAt: new Date(),
        updatedAt: new Date(),
        createdBy: user,
        updatedBy: user,
      };
      const typeToSave = this.repo.create(resortType);
      return this.repo.save(typeToSave);

    } catch (error) {
      if (error.code === PostgresErrorCode.UniqueValidation) {
        throw new ConflictException('ResortType already exists');
      }
      throw new HttpException(
        `Error create ResortType: ${error.message}`,
        HttpStatus.INTERNAL_SERVER_ERROR,
      )
    }
  }

  async findAll() {
    const res: ResortTypeResponse[] = await this.repo.find();
    if(res.length === 0) {
      throw new NotFoundException(`No ResortType found, Ensure mifgration has run`)
    }
  }

  async findOne(id: string) {
    const res = await this.repo.findOneBy({ id });

    if(!res) {
      throw new NotFoundException(`ResortType with ID ${id} is not found`)
    }
    return res;
  }

  async update(id: string, updateResortTypeDto: UpdateResortTypeDto, user: User): Promise<ResortType> {
    const resortType = await this.repo.findOneBy({id});
    if(!resortType) {
      throw new NotFoundException(`ResortType with ${id} not found`);
    }
    Object.assign(resortType, updateResortTypeDto);
    resortType.updatedBy = user;
    resortType.updatedAt = new Date();

    try {
      return await this.repo.save(resortType)
    } catch (error) {
      if(error.code == PostgresErrorCode.UniqueValidation) {
        throw new ConflictException(("Resort type already exists"))
      }
      throw new HttpException(
        `Error updating ResortType: ${error.message}`,
        HttpStatus.INTERNAL_SERVER_ERROR
      )
    }

  }

  async remove(id: string) {
    const result = await this.repo.delete(id);
    if (result.affected === 0) {
      throw new NotFoundException(`Resort type with ID: ${id} not found`)
    }
  }
}
