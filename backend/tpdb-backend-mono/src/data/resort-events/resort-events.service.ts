import { Injectable } from '@nestjs/common';
import { CreateResortEventDto } from './dto/create-resort-event.dto';
import { UpdateResortEventDto } from './dto/update-resort-event.dto';

@Injectable()
export class ResortEventsService {
  create(createResortEventDto: CreateResortEventDto) {
    return 'This action adds a new resortEvent';
  }

  findAll() {
    return `This action returns all resortEvents`;
  }

  findOne(id: number) {
    return `This action returns a #${id} resortEvent`;
  }

  update(id: number, updateResortEventDto: UpdateResortEventDto) {
    return `This action updates a #${id} resortEvent`;
  }

  remove(id: number) {
    return `This action removes a #${id} resortEvent`;
  }
}
