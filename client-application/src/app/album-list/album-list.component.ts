import { Component, OnInit } from '@angular/core';
import {Album} from "../models/album";
import {AlbumService} from "../services/album.service";
import {HttpErrorResponse} from "@angular/common/http";
import {Router} from "@angular/router";
import {KeycloakService} from "keycloak-angular";

@Component({
  selector: 'app-album-list',
  templateUrl: './album-list.component.html',
  styleUrls: ['./album-list.component.css']
})
export class AlbumListComponent implements OnInit {
  isAdmin = false;
  isGuest = false;

  albumId: number;
  public albums: Album[];

  constructor( private albumService: AlbumService, private router: Router, private keycloakService: KeycloakService) { }

  ngOnInit(): void {
    this.getAlbums();
    this.getRole();
  }

  public getAlbums(): void{
    this.albumService.getAllAlbums().subscribe(
      (data: Album[]) =>{
        this.albums = data;
      },
      (error: HttpErrorResponse) =>{
        alert(error.message);
      }
    )
  }

  public deleteAlbum(id: number){
    this.albumService.deleteALbum(id).subscribe( data =>{
      console.log(data);
      this.router.navigate(['/home']);
    })
  }

  public onAlbumView(id: number){
    this.router.navigate(['/album/details/', id]);
  }

  public onEditAlbum(id: number){
    this.router.navigate(['/album/edit', id]);
  }

  public reloadPage(){
    window.location.reload();
  }

  getRole(): void{
    if (this.keycloakService.isUserInRole('admin', 'photoalbum')){
      this.isAdmin = true;
    }
    else if (this.keycloakService.isUserInRole('superadmin', 'photoalbum')){
    } else
      this.isGuest = true;
  }

}
