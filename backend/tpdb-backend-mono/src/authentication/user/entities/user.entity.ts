import { Column, Entity, PrimaryGeneratedColumn, Unique } from 'typeorm';
import * as bcrypt from 'bcrypt';
import { Exclude } from 'class-transformer';

@Entity()
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

  @Column()
  salt: string;

  async validatePassword(password: string): Promise<boolean> {

    if (password) {
      const hash = await bcrypt.hash(password, this.salt);
      console.log(hash);
      const x = hash === this.password;
      return x;
    } else {
      return Promise.resolve(false);
    }

  }
}
