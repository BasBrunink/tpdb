import {inject, Injectable, signal, Signal} from '@angular/core';
import Keycloak from 'keycloak-js';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  private readonly keycloak = inject(Keycloak);
  userInfo$ = signal({})

  login() {
    this.keycloak.login().then(() => {
      this.userInfo$.set(this.keycloak.loadUserInfo());
    })
  }

  logout() {
    this.keycloak.logout().then(() => {
      this.userInfo$.set({});
    })
  }
}
