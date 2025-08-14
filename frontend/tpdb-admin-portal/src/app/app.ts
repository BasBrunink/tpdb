import {Component, inject, OnInit, signal} from '@angular/core';
import { RouterOutlet } from '@angular/router';
import Keycloak from 'keycloak-js';
import {HttpClient} from '@angular/common/http';
import {Header} from './common/components/header/header';
import {AuthenticationService} from './auth/authentication-service';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, Header],
  templateUrl: './app.html',
  styleUrl: './app.scss'
})
export class App implements OnInit{
  protected readonly title = signal('tpdb-admin-portal');
  private readonly authenticationService = inject(AuthenticationService);
  private readonly keycloak = inject(Keycloak);
  private readonly http = inject(HttpClient);
  ngOnInit() {
    this.http.get('http://localhost:8081/public/hello', {responseType: 'text'}).subscribe(
      data => this.message = data
    )
  }

  message?: string;
  userInfo$ = this.authenticationService.userInfo$;
  login() {
    this.authenticationService.login();
  }

  logout() {
    this.authenticationService.logout();
  }
}
