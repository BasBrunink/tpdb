import { Component } from '@angular/core';
import { NavigationStart, Router, RouterModule } from '@angular/router';
import { TranslateModule, TranslateService } from '@ngx-translate/core';
import { HeaderComponent } from './common/header/header.component';
import { MatDrawer, MatDrawerContainer } from '@angular/material/sidenav';
import { SideMenuComponent } from './common/side-menu/side-menu.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterModule, TranslateModule, HeaderComponent, MatDrawerContainer, MatDrawer, SideMenuComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  title = 'tpdb-admin-portal';

  showHeader: boolean = false;

  constructor(
    private router: Router,
    public translate: TranslateService) {
    translate.addLangs(['en','de','nl']);
    translate.setDefaultLang('en');
    const browserLang = translate.getBrowserLang();
    translate.use(browserLang?.match(/en|de|nl/) ? browserLang : 'en');
    router.events.forEach((event) => {
      if (event instanceof NavigationStart) {
        if (event['url'] == '/login' || event['url'] == '/register') {
          this.showHeader = false;
        } else {
          this.showHeader = true;
        }
      }
    }).then();

  }

}
