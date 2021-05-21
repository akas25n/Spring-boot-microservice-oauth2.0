import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {AlbumListComponent} from "./album-list/album-list.component";
import { CreateAlbumComponent } from './create-album/create-album.component';
import {AuthGuard} from "./utility/app.guard";
import {AlbumDetailsComponent} from "./album-details/album-details.component";
import {AddAlbumPhotosComponent} from "./add-album-photos/add-album-photos.component";


const routes: Routes = [
  {path:'home', component: AlbumListComponent, canActivate: [AuthGuard]},
  {path:'', redirectTo: 'home', pathMatch: 'full'},
  {path:'create-album', component: CreateAlbumComponent},
  {path:'album/details/:id', component: AlbumDetailsComponent},
  {path:'album/add-photos/:id', component: AddAlbumPhotosComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
