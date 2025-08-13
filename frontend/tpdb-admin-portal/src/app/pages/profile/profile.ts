import { Component } from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-profile',
  imports: [],
  templateUrl: './profile.html',
  styleUrl: './profile.scss'
})
export class Profile {
  message? : string;

  constructor(private http : HttpClient) {
    this.http.get('http://localhost:8081/admin/hello', {responseType: 'text'})
      .subscribe(data => this.message = data);
  }
}
