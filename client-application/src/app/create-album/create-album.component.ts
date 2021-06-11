import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Album } from '../models/album';
import { AlbumService } from '../services/album.service';

@Component({
  selector: 'app-create-album',
  templateUrl: './create-album.component.html',
  styleUrls: ['./create-album.component.css']
})
export class CreateAlbumComponent implements OnInit {

  album: Album = new Album();

  constructor( private albumService: AlbumService,
    private router: Router) { }

  ngOnInit(): void {
  }

  saveAlbum(){
    this.albumService.createAlbum(this.album).subscribe(data=>
      {console.log(data);
    },
      error=> console.log(error));
  }

  redirectToHome(){
    this.router.navigate(['/home']);
  }

  onSubmit(){
    this.saveAlbum();
    this.redirectToHome();

  }

  public reloadPage(){
    window.location.reload();
  }

  onCancel(){
    this.router.navigate(['/home']);
    window.location.reload();
  }

}
