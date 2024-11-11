import { BaseModel } from './baseModel.entity';
import { Column } from 'typeorm';

export abstract class BaseModelWithLocation extends BaseModel {
  @Column({ nullable: true })
  address: string;

  @Column({ nullable: true })
  city: string;

  @Column({ nullable: true })
  country: string;

  @Column({ nullable: true })
  gpsLong: string;

  @Column({ nullable: true })
  gpsLat: string;
}
