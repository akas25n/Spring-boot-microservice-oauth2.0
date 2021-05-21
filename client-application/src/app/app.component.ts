import { Component } from '@angular/core';
import {KeycloakService} from "keycloak-angular";
import {Router} from "@angular/router";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  isAdmin = false;
  isGuest = false;

  userName: string;
  userRole: string;

  title = 'client-application';

  constructor(private keycloakService: KeycloakService, private router: Router) {}

  async ngOnInit(){
    this.getUserName();
    this.getRole();
  }

  getUserName(): void{
    this.keycloakService.loadUserProfile().then(profile =>{
      this.userName = profile.firstName + ' ' + profile.lastName;
    });
  }

  logout(): void{
    this.keycloakService.logout();
    this.goHome();
  }

  goHome(){
    this.router.navigate(['/']);
  }

  getRole(): void{
    if (this.keycloakService.isUserInRole('admin', 'photoalbum')){
      this.userRole = "Admin";
      this.isAdmin = true;
    }
    else if (this.keycloakService.isUserInRole('superadmin', 'photoalbum')){
      this.userRole = "Super Admin";
    }
    else{
      this.userRole = "Guest";
      this.isGuest = true;
    }
  }
}
