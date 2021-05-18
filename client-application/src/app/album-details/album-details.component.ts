import { Component, OnInit } from '@angular/core';
import {AlbumResponse, PhotoResponse} from "../models/albumResponse";
import {AlbumService} from "../services/album.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-album-details',
  templateUrl: './album-details.component.html',
  styleUrls: ['./album-details.component.css']
})
export class AlbumDetailsComponent implements OnInit {

  id: number;
  albumResponse: AlbumResponse;

  constructor(private route: ActivatedRoute, private albumService: AlbumService) { }

  ngOnInit(): void {
    this.albumResponse = new AlbumResponse();
    let photo = new PhotoResponse();
    this.albumResponse.photos = [];

    this.id = this.route.snapshot.params['id'];
    this.albumService.getAlbumWithPhotos(this.id).subscribe(data =>{
      this.albumResponse = data;
    })
  }

}
