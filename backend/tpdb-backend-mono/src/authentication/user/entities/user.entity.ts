import { Column, Entity } from 'typeorm';
import { BaseModel } from '../../../common/enitities/baseModel.entity';

@Entity()
export class User extends BaseModel {
  @Column({ unique: true })
  public email: string;

  @Column()
  public password: string;

  @Column()
  public firstName: string;

  @Column()
  public lastName: string;
}
