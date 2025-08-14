import {Component, inject, OnInit, signal} from '@angular/core';
import { RouterOutlet } from '@angular/router';
import Keycloak from 'keycloak-js';
import {HttpClient} from '@angular/common/http';
import {Header} from './common/components/header/header';
import {JsonPipe} from '@angular/common';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, Header, JsonPipe],
  templateUrl: './app.html',
  styleUrl: './app.scss'
})
export class App implements OnInit{
  protected readonly title = signal('tpdb-admin-portal');
  private readonly keycloak = inject(Keycloak);
  private readonly http = inject(HttpClient);
  ngOnInit() {
    this.http.get('http://localhost:8081/public/hello', {responseType: 'text'}).subscribe(
      data => this.message = data
    )
  }

  message?: string;
  userInfo$ = this.keycloak.loadUserInfo();
  login() {
    this.keycloak.login();
  }

  logout() {
    this.keycloak.logout();
  }
}
