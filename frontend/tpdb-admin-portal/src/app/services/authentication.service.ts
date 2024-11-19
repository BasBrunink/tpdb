import { Injectable, Signal, signal } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../entities/user';
import { LoginResponseDto } from '../entities/dto/responses/loginResponse.dto';
import { LoginRequestDto } from '../entities/dto/requests/loginRequest.dto';
import { BehaviorSubject, Observable, Subscription, tap } from 'rxjs';
import { ProfileResponseDto } from '../entities/dto/responses/profileResponse.dto';

@Injectable({
  providedIn: 'root',
})
export class AuthenticationService {
  currentUser = signal<User  | undefined>(undefined);
  isLoggedIn = signal<boolean>(false)

  constructor(private readonly http: HttpClient) {

    const storedUser = localStorage.getItem('currentUser');
    if(storedUser)
      this.currentUser.set(JSON.parse(storedUser))
  }

  login(loginData: LoginRequestDto): Observable<LoginResponseDto> {
    return this.http.post<LoginResponseDto>('http://localhost:3000/auth/login', {
      email: loginData.email,
      password: loginData.password,
    }).pipe(
      tap(
        (res: LoginResponseDto) => {
          localStorage.setItem('token', res.accessToken);
          const user: User = new User();
          user.email = res.user.email;
          user.username = res.user.email;
          localStorage.setItem('currentUser', JSON.stringify(user))
          this.currentUser.set(user);
          this.isLoggedIn.set(true);
        }
      )
    )
  }
  logout() {
    localStorage.removeItem('token')
    localStorage.removeItem('currentUser')
    this.currentUser.set(undefined);
  }
  getProfile() {
    return this.http.get<ProfileResponseDto>('http://localhost:3000/auth/profile')
  }

}
