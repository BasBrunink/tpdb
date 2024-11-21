import { Column, Entity, PrimaryGeneratedColumn, Unique } from 'typeorm';
import { Exclude } from 'class-transformer';

@Entity()
@Exclude({ toPlainOnly: true })
@Unique(['email'])
export class User {
  @PrimaryGeneratedColumn('uuid')
  id: string;

  @Column()
  username: string;

  @Column()
  email: string;

  @Column()
  @Exclude()
  password: string;
}
