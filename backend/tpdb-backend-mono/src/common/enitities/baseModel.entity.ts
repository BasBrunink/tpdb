import { Column, PrimaryGeneratedColumn } from 'typeorm';

export abstract class BaseModel {
  @PrimaryGeneratedColumn('uuid')
  id: string;

  @Column({ nullable: true })
  createdAt: Date;

  @Column({ nullable: true })
  updatedAt: Date;

  //Todo: User createdBy updatedBy
}
