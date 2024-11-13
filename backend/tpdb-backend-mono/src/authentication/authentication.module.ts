import { Module } from '@nestjs/common';
import { UserModule } from './user/user.module';
import { AuthenticationService } from './authentication.service';


@Module({
  imports: [UserModule],
  providers: [AuthenticationService]
})
export class AuthenticationModule {}
