import {Component, inject, OnInit, signal} from '@angular/core';
import { RouterOutlet } from '@angular/router';
import Keycloak from 'keycloak-js';
import {AsyncPipe, JsonPipe} from '@angular/common';
import {HttpClient} from '@angular/common/http';
import {Header} from './common/components/header/header';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, AsyncPipe, JsonPipe, Header],
  templateUrl: './app.html',
  styleUrl: './app.scss'
})
export class App implements OnInit{
  protected readonly title = signal('tpdb-admin-portal');
  private readonly keycloak = inject(Keycloak)
  private readonly http = inject(HttpClient);
  ngOnInit() {
    this.http.get('http://localhost:8081/public/hello', {responseType: 'text'}).subscribe(
      data => this.message = data
    )
  }

  message?: string;
  isLoggedin$ = this.keycloak.loadUserInfo();
  isAdmin = this.keycloak.hasRealmRole("ADMIN")
  login() {
    this.keycloak.login();
  }

  logout() {
    this.keycloak.logout()
  }
}
