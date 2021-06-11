import { Component, OnInit } from '@angular/core';
import {AlbumResponse, PhotoResponse} from "../models/albumResponse";
import {AlbumService} from "../services/album.service";
import {ActivatedRoute, Router} from "@angular/router";
import {KeycloakService} from "keycloak-angular";

@Component({
  selector: 'app-album-details',
  templateUrl: './album-details.component.html',
  styleUrls: ['./album-details.component.css']
})
export class AlbumDetailsComponent implements OnInit {

  isAdmin = false;
  isSuperAdmin = false;
  isGuest = false;

  id: number;
  albumResponse: AlbumResponse;

  constructor(private route: ActivatedRoute, private albumService: AlbumService, private router: Router, private keycloakService: KeycloakService) { }

  ngOnInit(): void {
    this.getRole();

    this.albumResponse = new AlbumResponse();
    let photo = new PhotoResponse();
    this.albumResponse.photos = [];

    this.id = this.route.snapshot.params['id'];
    this.albumService.getAlbumWithPhotos(this.id).subscribe(data =>{
      this.albumResponse = data;
    })
  }

  onAddPhotos(id: number){
    id = this.route.snapshot.params['id'];
    this.router.navigate(['/album/add-photos/', id]);
  }

  redirectToHome(){
    this.router.navigate(['/home']);
  }

  getRole(): void{
    if (this.keycloakService.isUserInRole('admin', 'photoalbum')){
      this.isAdmin = true;
    }
    else if (this.keycloakService.isUserInRole('superadmin', 'photoalbum')){
      this.isSuperAdmin = true;
    }
    else{
      this.isGuest = true;
    }
  }

}
