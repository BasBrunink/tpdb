import { Routes } from '@angular/router';
import {canActivateAuthRole} from './auth/guards/auth.guard';


export const routes: Routes = [
  {
    path: 'admin',
    canActivate: [canActivateAuthRole],
    data: {role: 'ADMIN'},
    loadComponent: () => import('./pages/profile/profile').then(m => m.Profile)
  }
];
