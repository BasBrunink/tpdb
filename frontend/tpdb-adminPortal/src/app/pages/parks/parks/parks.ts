import {Component, inject, OnInit} from '@angular/core';
import {Park, ParkStatus, ParkType} from '../../../model/park.model';
import {MockParkService} from '../../../services/mockServices/mock-park-service';
import {MatTableModule} from '@angular/material/table';
import {MatButtonModule} from '@angular/material/button';
import {MatIconModule} from '@angular/material/icon';
import {TranslatePipe} from '@ngx-translate/core';
import {MatPaginatorModule} from '@angular/material/paginator';

@Component({
  selector: 'app-parks',
  imports: [
    MatTableModule,
    MatButtonModule,
    MatIconModule,
    TranslatePipe,
    MatPaginatorModule,
  ],
  templateUrl: './parks.html',
  styleUrl: './parks.scss'
})
export class Parks implements OnInit{



  //TODO: inject API service when done with page
  private parkService = inject(MockParkService);


  //Data
  parks: Park[] = [];


  ngOnInit() {
    this.parkService.getAllParks()
      .subscribe(d => {this.parks = d})
  }

  columnsToDisplay = ['name', 'parkType', 'status'];

  expandedElement: Park | null = null;

  toggleRow(element: Park) {
    this.expandedElement = this.expandedElement === element ? null : element;
  }

  getOpeningDateDisplay(park: Park): string {
    if (park.status === 'UNDER_CONSTRUCTION') {
      return park.opening ? park.opening.toFormat('dd-MM-yyyy') : 'no opening date yet'; //TODO: I18N
    }
    return park.opening ? park.opening.toFormat('dd-MM-yyyy') : 'no opening date yet';

  }

  getClosingDateDisplay(park: Park): string {
    return park.closing ? park.closing.toFormat('dd-MM-yyyy') : ''; //TODO: i18n
  }

  determineTranslationKeyForParkType(input: ParkType): string {
    return 'enum.parktype.' + input
  }

  determineTranslationKeyForParkStatus(input: ParkStatus): string {
    return 'enum.parkstatus.' + input
  }


  /** Checks whether an element is expanded. */


}
