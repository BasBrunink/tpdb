import { Injectable } from '@nestjs/common';
import { CreateResortDto } from './dto/create-resort.dto';
import { UpdateResortDto } from './dto/update-resort.dto';
import { Resort } from './entities/resort.entity';
import { Repository } from 'typeorm';
import { InjectRepository } from '@nestjs/typeorm';

@Injectable()
export class ResortService {
  constructor(
    @InjectRepository(Resort)
    private readonly resortRepo: Repository<Resort>,
  ) {}

  create(createResortDto: CreateResortDto) {
    const createdResort = this.resortRepo.create(createResortDto);
    return this.resortRepo.save(createdResort);
  }

  findAll() {
    return this.resortRepo.find();
  }

  findOne(id: string) {
    return this.resortRepo.findOne({ where: { id: id } });
  }

  update(id: string, updateResortDto: UpdateResortDto) {
    return `This action updates a #${id} resort, with ${updateResortDto}`;
  }

  remove(id: string) {
    return `This action removes a #${id} resort`;
  }
}
