import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../entities/user';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor(
    private http: HttpClient
  ) {
  }

  login(username: string, password: string): Observable<User>{
    return this.http.post<User>('localhost:3000/authentication/log-in', { username: username, password: password })
  }
}
