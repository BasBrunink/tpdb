import { Component } from '@angular/core';
import { MatCard, MatCardActions, MatCardContent, MatCardTitle } from '@angular/material/card';
import { TranslateModule } from '@ngx-translate/core';
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { MatFormField, MatLabel } from '@angular/material/form-field';
import { MatButton } from '@angular/material/button';
import { MatInput } from '@angular/material/input';
import { Router } from '@angular/router';
import { AuthenticationService } from '../../../services/authentication.service';
import { LoginResponseDto } from '../../../entities/responses/loginResponse.dto';
import { User } from '../../../entities/user';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [
    MatCard,
    MatCardTitle,
    TranslateModule,
    MatCardContent,
    MatCardActions,

    ReactiveFormsModule,
    MatFormField,
    MatLabel,
    MatButton,
    MatInput,

  ],
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss'
})
export class LoginComponent {

  loginForm: FormGroup;

  constructor(
    private router: Router,
    private http: HttpClient,
    private authService: AuthenticationService,
    private readonly _fb: FormBuilder,
    private readonly authservice: AuthenticationService

  ){
    this.loginForm = this._fb.group({
      email: ['', {validators: [Validators.required, Validators.email]}],
      password: ['', {validators: [Validators.required]}]
    })
  }


  login() {
    this.http.post<LoginResponseDto>('http://localhost:3000/auth/login', { email: this.loginForm.controls['email'].value, password: this.loginForm.controls['password'].value }).subscribe((response: LoginResponseDto) => {
      localStorage.setItem('token', response.accessToken);
      const user: User = new User();
      user.email = response.user.email;
      user.username = response.user.username;
      this.authService.currentUser.set(user);

      this.router.navigate(['/dashboard']);
    })
  }

  register() {
    this.router.navigate(['/register']);
  }
}
