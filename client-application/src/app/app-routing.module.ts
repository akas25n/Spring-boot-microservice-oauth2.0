import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {AlbumListComponent} from "./album-list/album-list.component";
import { CreateAlbumComponent } from './create-album/create-album.component';
import {AuthGuard} from "./utility/app.guard";
import {AlbumDetailsComponent} from "./album-details/album-details.component";


const routes: Routes = [
  {path:'home', component: AlbumListComponent, canActivate: [AuthGuard]},
  {path:'', redirectTo: 'home', pathMatch: 'full'},
  {path:'create-album', component: CreateAlbumComponent},
  {path:'album/details/:id', component: AlbumDetailsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
