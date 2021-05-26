import { Component, OnInit } from '@angular/core';
import {Album} from "../models/album";
import {AlbumService} from "../services/album.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-edit-album',
  templateUrl: './edit-album.component.html',
  styleUrls: ['./edit-album.component.css']
})
export class EditAlbumComponent implements OnInit {

  id: number;
  album: Album = new Album();

  constructor(private albumService: AlbumService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.albumService.getSingleAlbum(this.id).subscribe(data =>{
      this.album = data;
    },
      error => console.log(error));
  }

  goToHome(){
    this.router.navigate(['/home']);
  }

  onSubmit(){
    this.albumService.editAlbum(this.id, this.album).subscribe(data=> {
      this.goToHome();
    },
      error => console.log(error));
  }

  onCancel(){
    this.goToHome();
  }



}
