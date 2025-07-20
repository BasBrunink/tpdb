import { Component } from '@angular/core';
import {TranslatePipe} from '@ngx-translate/core';
import {FormsModule} from '@angular/forms';
import {MatInputModule} from '@angular/material/input';

@Component({
  selector: 'app-add-park',
  imports: [
    FormsModule,
    MatInputModule,
    TranslatePipe
  ],
  templateUrl: './add-park.html',
  styleUrl: './add-park.scss'
})
export class AddPark {

}
