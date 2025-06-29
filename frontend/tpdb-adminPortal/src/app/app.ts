import {Component, inject, OnDestroy, OnInit} from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {Subscription} from 'rxjs';
import {takeUntilDestroyed} from '@angular/core/rxjs-interop';
import {AsyncPipe, JsonPipe} from '@angular/common';
import {ParkService} from './services/park/park.service';
import {Park} from './model/park.model';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, JsonPipe, AsyncPipe],
  templateUrl: './app.html',
  styleUrl: './app.scss'
})
export class App implements OnInit{
  parks: Park[] = [];




  private parkService = inject(ParkService);



  protected title = 'tpdb-adminPortal';

  ngOnInit() {
    this.parkService.getAllParks().subscribe({
      next: (parks) => this.parks = parks,
      error: err => console.error(err)
    })
  }


}
