import { Routes } from '@angular/router';
import {Home} from './pages/home/home';
import {Parks} from './pages/parks/parks/parks';
import {Resorts} from './pages/resorts/resorts/resorts';
import {AddPark} from './pages/parks/add-park/add-park';

export const routes: Routes = [
  {path: 'home', component: Home},
  {path: 'park',component: Parks},
  {path: 'park/add',component: AddPark},
  {path: 'resort', component: Resorts},
  {path: '', redirectTo: 'home', pathMatch: "full"}
];
