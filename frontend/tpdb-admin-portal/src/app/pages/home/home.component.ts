import { Component, OnInit, signal } from '@angular/core';
import { TranslateModule } from '@ngx-translate/core';
import { AuthenticationService } from '../../services/authentication.service';
import { ProfileResponseDto } from '../../entities/dto/responses/profileResponse.dto';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [
    TranslateModule,
  ],
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss',
})
export class HomeComponent implements OnInit {
  profile = signal<ProfileResponseDto | undefined>(undefined);

  constructor(
    private readonly authService: AuthenticationService,
  ) {
  }

  ngOnInit(): void {
    if(localStorage.getItem('currentUser')) {
      this.authService.getProfile().subscribe((res: ProfileResponseDto) => {
        this.profile.set(res);

      });
    }




  }


}
