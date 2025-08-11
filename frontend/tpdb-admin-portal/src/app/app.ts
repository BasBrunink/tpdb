import {Component, inject, signal} from '@angular/core';
import { RouterOutlet } from '@angular/router';
import Keycloak from 'keycloak-js';
import {AsyncPipe, JsonPipe} from '@angular/common';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, AsyncPipe, JsonPipe],
  templateUrl: './app.html',
  styleUrl: './app.scss'
})
export class App {
  protected readonly title = signal('tpdb-admin-portal');
  private readonly keycloak = inject(Keycloak)

  isLoggedin$ = this.keycloak.loadUserInfo();
  isAdmin = this.keycloak.hasRealmRole("ADMIN")
  login() {
    this.keycloak.login();
  }

  logout() {
    this.keycloak.logout()
  }
}
