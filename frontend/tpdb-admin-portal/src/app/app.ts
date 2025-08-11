import {Component, inject, signal} from '@angular/core';
import { RouterOutlet } from '@angular/router';
import Keycloak from 'keycloak-js';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet],
  templateUrl: './app.html',
  styleUrl: './app.scss'
})
export class App {
  protected readonly title = signal('tpdb-admin-portal');
  private readonly keycloak = inject(Keycloak)

  isLoggedin$ = this.keycloak.authenticated;
  login() {
    this.keycloak.login();
  }

  logout() {
    this.keycloak.logout()
  }
}
