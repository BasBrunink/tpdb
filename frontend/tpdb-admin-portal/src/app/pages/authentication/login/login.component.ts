import { Component } from '@angular/core';
import { MatCard, MatCardActions, MatCardContent, MatCardTitle } from '@angular/material/card';
import { TranslateModule } from '@ngx-translate/core';
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { MatFormField, MatLabel } from '@angular/material/form-field';
import { MatButton } from '@angular/material/button';
import { MatInput } from '@angular/material/input';
import { Router } from '@angular/router';
import { AuthenticationService } from '../../../services/authentication.service';

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
    private readonly _fb: FormBuilder,
    private readonly authservice: AuthenticationService

  ){
    this.loginForm = this._fb.group({
      email: ['', {validators: [Validators.required, Validators.email]}],
      password: ['', {validators: [Validators.required]}]
    })
  }


  login() {

    this.authservice.login(this.loginForm.controls['email'].value, this.loginForm.controls['password'].value).subscribe(user => {
      console.log(user);
    })
    //works now but will be replaced with actual login logic
  }

  register() {
    this.router.navigate(['/register']);
  }
}
