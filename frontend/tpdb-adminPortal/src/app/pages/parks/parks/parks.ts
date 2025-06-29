import {Component, inject, OnInit} from '@angular/core';
import {Park} from '../../../model/park.model';
import {ParkService} from '../../../services/park/park.service';

@Component({
  selector: 'app-parks',
  imports: [],
  templateUrl: './parks.html',
  styleUrl: './parks.scss'
})
export class Parks implements OnInit{


  parks: Park[] = [];




  private parkService = inject(ParkService);




  ngOnInit() {
    this.parkService.getAllParks().subscribe({
      next: (parks) => this.parks = parks,
      error: err => console.error(err)
    })
  }

}
