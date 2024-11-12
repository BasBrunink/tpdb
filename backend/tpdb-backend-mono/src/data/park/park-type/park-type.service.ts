import { Injectable } from '@nestjs/common';
import { CreateParkTypeDto } from './dto/create-park-type.dto';
import { UpdateParkTypeDto } from './dto/update-park-type.dto';
import { InjectRepository } from '@nestjs/typeorm';
import { ParkType } from './entities/park-type.entity';
import { Repository } from 'typeorm';

@Injectable()
export class ParkTypeService {

  constructor(
    @InjectRepository(ParkType)
    private readonly repo: Repository<ParkType>) {
  }

  create(createParkTypeDto: CreateParkTypeDto) {

    const typeToSave = this.repo.create(createParkTypeDto);
    typeToSave.createdAt = new Date();
    typeToSave.updatedAt = new Date();
    return this.repo.save(typeToSave);

  }

  findAll() {
    return this.repo.find();
  }

  findOne(id: string) {
    return this.repo.findOne({ where: { id: id } });
  }

  update(id: string, updateParkTypeDto: UpdateParkTypeDto) {

    const typeToUpdate = this.findOne(id).then((type) => {
      type.updatedAt = new Date();
      type.name = updateParkTypeDto.name;
      type.description = updateParkTypeDto.description;
      this.repo.update(id, type).then(r => {
        return r;
      });
    });
  }

  remove(id: string) {
    return this.repo.delete(id);
  }
}
