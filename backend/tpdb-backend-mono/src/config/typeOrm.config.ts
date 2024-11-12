import { DataSource } from 'typeorm';
import { ConfigService} from '@nestjs/config';
import { config } from 'dotenv';
import { Resort } from '../data/resort/entities/resort.entity';
import { Park } from '../data/park/entities/park.entity';
import { ParkType } from '../data/park/park-type/entities/park-type.entity';
import { Accomodation } from '../data/accomodation/entities/accomodation.entity';
import { AccomodationType } from '../data/accomodation/accomodation-type/entities/accomodation-type.entity';
import { AccomodationAmenity } from '../data/accomodation/accomodation-amenities/entities/accomodation-amenity.entity';


config();

const configService = new ConfigService();

export default new DataSource({
  type: 'postgres',
  host: configService.get('POSTGRES_HOST'),
  port: configService.get('POSTGRES_PORT'),
  username: configService.get('POSTGRES_USER'),
  password: configService.get('POSTGRES_PASSWORD'),
  database: configService.get('POSTGRES_DB'),
  entities: [Resort, Park, ParkType, Accomodation, AccomodationType, AccomodationAmenity],
  migrations: ['./migrations/structure/*{.ts,js}', './migrations/dummy/*{.ts,js}', './migrations/seed/*{.ts,js}'],
});
