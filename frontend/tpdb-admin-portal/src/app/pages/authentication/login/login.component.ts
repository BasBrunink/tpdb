import { Component, OnInit } from '@angular/core';
import { MatCard, MatCardActions, MatCardContent, MatCardTitle } from '@angular/material/card';
import { TranslateModule } from '@ngx-translate/core';
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { MatFormField, MatLabel } from '@angular/material/form-field';
import { MatButton } from '@angular/material/button';
import { MatInput } from '@angular/material/input';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthenticationService } from '../../../services/authentication.service';
import { LoginResponseDto } from '../../../entities/dto/responses/loginResponse.dto';
import { User } from '../../../entities/user';
import { HttpClient } from '@angular/common/http';
import { LoginRequestDto } from '../../../entities/dto/requests/loginRequest.dto';

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
export class LoginComponent implements OnInit {

  loginForm: FormGroup;

  invalidCredentialMsg: string = '';
  username:string = '';
  password:string = '';
  retUrl:string | null='dashboard';

  constructor(
    private router: Router,
    private activatedRoute: ActivatedRoute,
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


  ngOnInit() {
    this.activatedRoute.queryParamMap.subscribe(params => {
        this.retUrl = params.get('retUrl');
      }
    )
  }


  login() {
    const loginRequest: LoginRequestDto = {
      email: this.loginForm.value.email,
      password: this.loginForm.value.password
    }
    this.authService.login(loginRequest).subscribe(data  => {
      if(this.retUrl != null) {
        this.router.navigate([this.retUrl]);
      } else {
        this.router.navigate(['home']);
      }
    })
  }

  register() {
    this.router.navigate(['/register']);
  }
}
