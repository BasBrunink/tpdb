import { DataSource } from 'typeorm';
import { ConfigService } from '@nestjs/config';
import { config } from 'dotenv';
import { Resort } from '../data/resort/entities/resort.entity';
import { Park } from '../data/park/entities/park.entity';
import { ParkType } from '../data/types/park-type/entities/park-type.entity';
import { Accomodation } from '../data/accomodation/entities/accomodation.entity';
import { AccomodationType } from '../data/types/accomodation-type/entities/accomodation-type.entity';
import { AccomodationAmenity } from '../data/accomodation/accomodation-amenities/entities/accomodation-amenity.entity';
import { Company } from '../data/company/entities/company.entity';
import { Attraction } from '../data/attraction/entities/attraction.entity';
import { AttractionType } from '../data/types/attraction-type/entities/attraction-type.entity';
import { ResortEvent } from '../data/resort-events/entities/resort-event.entity';
import { ResortInternalTransportation } from '../data/resort-internal-transportation/entities/resort-internal-transportation.entity';
import { Restaurant } from '../data/restaurant/entities/restaurant.entity';
import { Ride } from '../data/ride/entities/ride.entity';
import { TravelOption } from '../data/travel-option/entities/travel-option.entity';

config();

const configService = new ConfigService();

export default new DataSource({
  type: 'postgres',
  host: configService.get('POSTGRES_HOST'),
  port: configService.get('POSTGRES_PORT'),
  username: configService.get('POSTGRES_USER'),
  password: configService.get('POSTGRES_PASSWORD'),
  database: configService.get('POSTGRES_DB'),
  entities: [
    Accomodation,
    AccomodationType,
    AccomodationAmenity,
    Attraction,
    AttractionType,
    Company,
    Park,
    ParkType,
    Resort,
    ResortEvent,
    ResortInternalTransportation,
    Restaurant,
    Ride,
    TravelOption,
  ],
  migrations: [
    // './migrations/structure/*{.ts,js}',
    './migrations/dummy/*{.ts,js}',
    './migrations/seed/*{.ts,js}',
  ],
});
