import { Injectable } from '@nestjs/common';
import { CreateResortTypeDto } from './dto/create-resort-type.dto';
import { UpdateResortTypeDto } from './dto/update-resort-type.dto';
import { InjectRepository } from '@nestjs/typeorm';
import { ResortType } from './entities/resort-type.entity';
import { Repository } from 'typeorm';
import { User } from '../../../authentication/user/entities/user.entity';

@Injectable()
export class ResortTypeService {

  constructor(
    @InjectRepository(ResortType)
    private readonly repo: Repository<ResortType>,
  ) {}

  create(createResortTypeDto: CreateResortTypeDto, user: User) {
    return 'This action adds a new resortType';
  }

  findAll() {
    return `This action returns all resortType`;
  }

  findOne(id: string) {
    return `This action returns a #${id} resortType`;
  }

  update(id: string, updateResortTypeDto: UpdateResortTypeDto) {
    return `This action updates a #${id} resortType`;
  }

  remove(id: string) {
    return `This action removes a #${id} resortType`;
  }
}
