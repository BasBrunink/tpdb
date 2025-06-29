import { Routes } from '@angular/router';
import {Home} from './pages/home/home';
import {Parks} from './pages/parks/parks/parks';

export const routes: Routes = [
  {path: 'home', component: Home},
  {path: 'park',component: Parks},
  {path: '', redirectTo: 'home', pathMatch: "full"}
];
