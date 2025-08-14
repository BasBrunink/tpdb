import { Component } from '@angular/core';
import {MatToolbar} from '@angular/material/toolbar';
import {MatIcon} from '@angular/material/icon';
import {MatIconButton} from '@angular/material/button';
import {TranslatePipe} from '@ngx-translate/core';
@Component({
  selector: 'app-header',
  imports: [
    TranslatePipe,
    MatToolbar,
    MatIcon,
    MatIconButton
  ],
  templateUrl: './header.html',
  styleUrl: './header.scss'
})
export class Header {

}
