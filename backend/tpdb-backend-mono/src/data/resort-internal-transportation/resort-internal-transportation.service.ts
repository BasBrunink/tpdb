import { Injectable } from '@nestjs/common';
import { CreateResortInternalTransportationDto } from './dto/create-resort-internal-transportation.dto';
import { UpdateResortInternalTransportationDto } from './dto/update-resort-internal-transportation.dto';

@Injectable()
export class ResortInternalTransportationService {
  create(createResortInternalTransportationDto: CreateResortInternalTransportationDto) {
    return 'This action adds a new resortInternalTransportation';
  }

  findAll() {
    return `This action returns all resortInternalTransportation`;
  }

  findOne(id: number) {
    return `This action returns a #${id} resortInternalTransportation`;
  }

  update(id: number, updateResortInternalTransportationDto: UpdateResortInternalTransportationDto) {
    return `This action updates a #${id} resortInternalTransportation`;
  }

  remove(id: number) {
    return `This action removes a #${id} resortInternalTransportation`;
  }
}
