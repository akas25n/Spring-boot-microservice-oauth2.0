import { Component, OnInit } from '@angular/core';
import {Album} from "../models/album";
import {AlbumService} from "../services/album.service";
import {HttpErrorResponse} from "@angular/common/http";
import {Router} from "@angular/router";

@Component({
  selector: 'app-album-list',
  templateUrl: './album-list.component.html',
  styleUrls: ['./album-list.component.css']
})
export class AlbumListComponent implements OnInit {

  albumId: number;
  public albums: Album[];

  constructor( private albumService: AlbumService, private router: Router) { }

  ngOnInit(): void {
    this.getAlbums();
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
      this.reloadPage();
    })
  }

  public onAlbumView(id: number){
    this.router.navigate(['/album/details/', id]);
  }

  public reloadPage(){
    window.location.reload();
  }

}
