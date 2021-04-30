import { Component, OnInit } from '@angular/core';
import {Album} from "../models/album";
import {AlbumService} from "../services/album.service";
import {HttpErrorResponse} from "@angular/common/http";

@Component({
  selector: 'app-album-list',
  templateUrl: './album-list.component.html',
  styleUrls: ['./album-list.component.css']
})
export class AlbumListComponent implements OnInit {

  public albums: Album[];

  constructor( private albumService: AlbumService) { }

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

}
