import {Component, inject, OnInit} from '@angular/core';
import {Park, ParkStatus, ParkType} from '../../../model/park.model';
import {MockParkService} from '../../../services/mockServices/mock-park-service';
import {MatTableModule} from '@angular/material/table';
import {MatButtonModule} from '@angular/material/button';
import {MatIconModule} from '@angular/material/icon';
import {TranslatePipe} from '@ngx-translate/core';
import {MatPaginatorModule, PageEvent} from '@angular/material/paginator';
import {ParkService} from '../../../services/park/park.service';
import {Observable} from 'rxjs';

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
  private parkService = inject(ParkService);


  //Data
  //TODO: need to find a way to make this responsive
  parks: Park[] = [];


  totalElements = 0;
  pagesize = 10;
  pageindex = 0;
  ngOnInit() {
    this.loadParks(this.pageindex, this.pagesize)
  }

  columnsToDisplay = ['name', 'parkType', 'status'];

  expandedElement: Park | null = null;

  onPageChange(event: PageEvent) {
    this.pageindex = event.pageIndex
    this.pagesize = event.pageSize
    this.loadParks(this.pageindex, this.pagesize);
  }

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

  loadParks(page: number, size: number) {
    this.parkService.getAllParks(page, size).subscribe(res => {
      this.parks = res.content;
      this.totalElements = res.totalElements;
    })
  }

}
