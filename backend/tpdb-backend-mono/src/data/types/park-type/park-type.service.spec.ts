import { Test, TestingModule } from '@nestjs/testing';
import { ParkTypeService } from './park-type.service';
import { Repository } from 'typeorm';
import { getRepositoryToken } from '@nestjs/typeorm';
import { ParkType } from './entities/park-type.entity';
import { ConflictException, NotFoundException } from '@nestjs/common';
import { CreateParkTypeDto } from './dto/create-park-type.dto';
import { UpdateParkTypeDto } from './dto/update-park-type.dto';
import { PostgresErrorCode } from '../../../database/postgresErrorCodes.enum';

describe('ParkTypeService', () => {
  let service: ParkTypeService;
  let repo: jest.Mocked<Repository<ParkType>>;

  beforeEach(async () => {
    const module: TestingModule = await Test.createTestingModule({
      providers: [
        ParkTypeService,
        {
          provide: getRepositoryToken(ParkType),
          useValue: {
            create: jest.fn(),
            save: jest.fn(),
            find: jest.fn(),
            findOneBy: jest.fn(),
            delete: jest.fn(),
          },
        },
      ],
    }).compile();

    service = module.get<ParkTypeService>(ParkTypeService);
    repo = module.get<jest.Mocked<Repository<ParkType>>>(
      getRepositoryToken(ParkType),
    );
  });

});
