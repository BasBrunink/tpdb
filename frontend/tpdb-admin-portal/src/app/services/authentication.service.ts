import { Injectable, signal } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../entities/user';
import { Observable } from 'rxjs';
import { LoginResponseDto } from '../entities/responses/loginResponse.dto';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  currentUser = signal<User | undefined | null>(undefined)



}
