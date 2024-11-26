import { ConflictException, HttpException, HttpStatus, Injectable } from '@nestjs/common';
import { CreateResortDto } from './dto/create-resort.dto';
import { UpdateResortDto } from './dto/update-resort.dto';
import { Resort } from './entities/resort.entity';
import { Repository } from 'typeorm';
import { InjectRepository } from '@nestjs/typeorm';
import { User } from '../../authentication/user/entities/user.entity';
import { ResortTypeService } from '../types/resort-type/resort-type.service';
import { CompanyService } from '../company/company.service';
import { PostgresErrorCode } from '../../database/postgresErrorCodes.enum';

@Injectable()
export class ResortService {
  constructor(
    @InjectRepository(Resort)
    private readonly resortRepo: Repository<Resort>,
    private readonly typeService: ResortTypeService,
    private readonly companyService: CompanyService,

  ) {}

  async create(createResortDto: CreateResortDto, user: User) {

    const resortToSave = await this._convertToResort(createResortDto)
    resortToSave.createdBy = user;
    resortToSave.updatedBy = user;
    resortToSave.createdAt = new Date();
    resortToSave.updatedAt = new Date();
    try {
      return this.resortRepo.save(resortToSave);
    } catch (error) {
      if(error.code === PostgresErrorCode.UniqueValidation) {
        throw new ConflictException('Resort already exists');
      }
      throw new HttpException(`Resort create oops: ${error.message}`, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  findAll() {
    return this.resortRepo.find();
  }

  findOne(id: string) {
    return this.resortRepo.findOne({ where: { id: id } });
  }

  update(id: string, updateResortDto: UpdateResortDto, user: User) {
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
