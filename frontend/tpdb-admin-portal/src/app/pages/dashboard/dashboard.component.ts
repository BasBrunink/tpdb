import { Component, computed, OnInit, signal } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../../models/user';
import { AuthenticationService } from '../../services/authentication.service';

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [],
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.scss'
})
export class DashboardComponent implements OnInit {

  user = signal<User>(new User());

  constructor(
    private readonly http: HttpClient,
    protected readonly authService: AuthenticationService
  ) { }

  ngOnInit(): void {
    if(this.authService.isLoggedIn()) {

    }

    }
}

