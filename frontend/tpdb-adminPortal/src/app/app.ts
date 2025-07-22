import {Component} from '@angular/core';
import {RouterOutlet} from '@angular/router';
import {HeaderComponent} from './components/common/header/header.component/header.component';
import {TranslateService} from '@ngx-translate/core';
import {MatLuxonDateModule} from '@angular/material-luxon-adapter';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, HeaderComponent],
  templateUrl: './app.html',
  styleUrl: './app.scss'
})
export class App {


  protected title = 'tpdb-adminPortal';

  constructor(private translate: TranslateService) {
    translate.addLangs(['en', 'nl', 'de'])
    translate.setDefaultLang('en')

    const browserLang = translate.getBrowserLang();
    if (browserLang != null) {
      translate.use(browserLang.match(/en|de/) ? browserLang : 'en');
    }
  }




}
