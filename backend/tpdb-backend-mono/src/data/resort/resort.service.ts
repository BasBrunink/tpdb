import { Injectable } from '@nestjs/common';
import { CreateResortDto } from './dto/create-resort.dto';
import { UpdateResortDto } from './dto/update-resort.dto';
import { Resort } from './entities/resort.entity';
import { Repository } from 'typeorm';
import { InjectRepository } from '@nestjs/typeorm';
import { User } from '../../authentication/user/entities/user.entity';

@Injectable()
export class ResortService {
  constructor(
    @InjectRepository(Resort)
    private readonly resortRepo: Repository<Resort>,
  ) {}

  create(createResortDto: CreateResortDto, user: User) {
    console.dir(user);
    const resortToSave = this._convertToResort(createResortDto);
    console.dir(resortToSave);
    resortToSave.createdBy = user;
    resortToSave.updatedBy = user;
    resortToSave.createdAt = new Date();
    resortToSave.updatedAt = new Date();
    return this.resortRepo.save(resortToSave);
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

  private _convertToResort(createResortDto: CreateResortDto): Resort {
    const resort: Resort = new Resort();
    resort.name = createResortDto.name;
    resort.description = createResortDto.description;
    return resort;
  }
}
