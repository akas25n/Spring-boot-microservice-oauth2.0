import { Component, OnInit } from '@angular/core';
import {Photo} from "../models/photo";
import {PhotoService} from "../services/photo.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-add-album-photos',
  templateUrl: './add-album-photos.component.html',
  styleUrls: ['./add-album-photos.component.css']
})
export class AddAlbumPhotosComponent implements OnInit {

  id: number;
  photo : Photo = new Photo();

  constructor(private photoService: PhotoService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
  }

  addAlbumPhotos(){
    this.id = this.route.snapshot.params['id'];
    this.photoService.addPhotos(this.photo, this.id).subscribe( data =>{
      console.log(data);
    })
  }

  onSubmit(){
    this.addAlbumPhotos();
    this.backToAlbumDetails();
  }

  onCancel(){
    this.backToAlbumDetails();
  }

  backToAlbumDetails(){
    this.id = this.route.snapshot.params['id'];
    this.router.navigate(['/album/details/', this.id]);
  }

}
