import { Component, OnInit, signal } from '@angular/core';
import { TranslateModule } from '@ngx-translate/core';
import { AuthenticationService } from '../../services/authentication.service';
import { ProfileResponseDto } from '../../models/dto/responses/profileResponse.dto';

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





  }


}
