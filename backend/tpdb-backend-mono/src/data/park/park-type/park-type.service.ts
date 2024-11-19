import {
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

@Injectable()
export class ParkTypeService {
  constructor(
    @InjectRepository(ParkType)
    private readonly repo: Repository<ParkType>,
  ) {}

  create(createParkTypeDto: CreateParkTypeDto) {
    try {
      const typeToSave = this.repo.create(createParkTypeDto);
      typeToSave.createdAt = new Date();
      typeToSave.updatedAt = new Date();
      return this.repo.save(typeToSave);
    } catch (error) {
      throw new HttpException(
        `OOPS, ${error}`,
        HttpStatus.INTERNAL_SERVER_ERROR,
      );
    }
  }

  async findAll() {
    const res = await this.repo.find();
    if (!res) {
      throw new NotFoundException(
        `The ParkType table is empty probably teh migration has not run`,
      );
    }
    return res;
  }

  async findOne(id: string) {
    const res = await this.repo.findOne({ where: { id: id } });

    if (!res) {
      throw new NotFoundException(`Parktype with ID ${id} isnot found`);
    }
    return res;
  }

  update(id: string, updateParkTypeDto: UpdateParkTypeDto) {
    this.findOne(id).then((type) => {
      type.updatedAt = new Date();
      type.name = updateParkTypeDto.name;
      type.description = updateParkTypeDto.description;
      this.repo.update(id, type).then((r) => {
        return r;
      });
    });
  }

  remove(id: string) {
    return this.repo.delete(id);
  }
}
