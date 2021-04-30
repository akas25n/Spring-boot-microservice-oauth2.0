import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {AlbumListComponent} from "./album-list/album-list.component";
import { CreateAlbumComponent } from './create-album/create-album.component';

const routes: Routes = [
  {path:'home', component: AlbumListComponent},
  {path:'', redirectTo: 'home', pathMatch: 'full'},
  {path:'create-album', component: CreateAlbumComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
