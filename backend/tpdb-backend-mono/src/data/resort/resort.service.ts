import { Injectable } from '@nestjs/common';
import { CreateResortDto } from './dto/create-resort.dto';
import { UpdateResortDto } from './dto/update-resort.dto';
import { Resort } from './entities/resort.entity';
import { Repository } from 'typeorm';
import { InjectRepository } from '@nestjs/typeorm';
import { User } from '../../authentication/user/entities/user.entity';
import { ResortTypeService } from '../types/resort-type/resort-type.service';
import { CompanyService } from '../company/company.service';

@Injectable()
export class ResortService {
  constructor(
    @InjectRepository(Resort)
    private readonly resortRepo: Repository<Resort>,
    private readonly typeService: ResortTypeService,
    private readonly companyService: CompanyService,

  ) {}

  async create(createResortDto: CreateResortDto, user: User) {

    const resort = this._convertToResort(createResortDto);
    console.dir(user);
    const resortToSave = await this._convertToResort(createResortDto);
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

  private async _convertToResort(dto: CreateResortDto | UpdateResortDto): Promise<Resort> {
    const resort: Resort = new Resort();
    resort.name = dto.name;
    resort.description = dto.description;
    resort.openingDate = new Date(dto.openingDate);
    resort.closingDate = new Date(dto.closingDate);
    resort.area = dto.area;
    resort.seasonality = dto.seasonality;
    resort.resortType = await this.typeService.findOne(dto.resortTypeId)
    resort.owner = await this.companyService.findOne(dto.ownerId)
    resort.operator = await this.companyService.findOne(dto.operatorId)

    return resort;
  }
}
