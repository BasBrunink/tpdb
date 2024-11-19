import { Component, OnInit, signal } from '@angular/core';
import { TranslateModule } from '@ngx-translate/core';
import { ProfileResponseDto } from '../../../models/dto/responses/profileResponse.dto';
import { AuthenticationService } from '../../../services/authentication.service';
import { Profile } from '../../../models/profile.model';

@Component({
  selector: 'app-profile',
  standalone: true,
  imports: [
    TranslateModule,
  ],
  templateUrl: './profile.component.html',
  styleUrl: './profile.component.scss',
})
export class ProfileComponent implements OnInit {

  profile =  signal<Profile | undefined>(undefined)


  constructor( private readonly authService: AuthenticationService) {
  }

  ngOnInit() {
    this.authService.getProfile().subscribe((res: ProfileResponseDto) => {
      const tmp: Profile = new Profile()
      tmp.id = res.id;
      tmp.username = res.username;
      tmp.email = res.email
      this.profile.set(tmp);
    });
  }
}
