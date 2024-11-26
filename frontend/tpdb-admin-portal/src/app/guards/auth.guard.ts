import { Injectable } from '@angular/core';
import {

  ActivatedRouteSnapshot,
  CanActivate,

  Router,
  RouterStateSnapshot, UrlTree,
} from '@angular/router';
import { AuthenticationService } from '../services/authentication.service';


@Injectable({
  providedIn: 'root',
})
export class AuthGuard implements CanActivate {

  constructor(
    private readonly authService: AuthenticationService,
    private readonly router: Router
  ) {
  }


  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean| UrlTree {

    if(!this.authService.isLoggedIn()) {

      this.router.navigate(['login'], {queryParams: {retUrl: route.url}})
      return false;
    }
    return true;
  }
}
