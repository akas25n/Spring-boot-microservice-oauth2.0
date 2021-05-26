import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AlbumListComponent } from './album-list/album-list.component';
import { CreateAlbumComponent } from './create-album/create-album.component';
import { FormsModule } from '@angular/forms';
import {APP_INITIALIZER, NgModule} from "@angular/core";
import {HttpClientModule} from "@angular/common/http";
import {KeycloakAngularModule, KeycloakService} from "keycloak-angular";
import {initializeKeycloak} from "./utility/app.init";
import { AlbumDetailsComponent } from './album-details/album-details.component';
import { AddAlbumPhotosComponent } from './add-album-photos/add-album-photos.component';
import { EditAlbumComponent } from './edit-album/edit-album.component';

@NgModule({
  declarations: [
    AppComponent,
    AlbumListComponent,
    CreateAlbumComponent,
    AlbumDetailsComponent,
    AddAlbumPhotosComponent,
    EditAlbumComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    KeycloakAngularModule
  ],
  providers: [
    {
      provide: APP_INITIALIZER,
      useFactory: initializeKeycloak,
      multi: true,
      deps: [KeycloakService],
    },
  ],
  bootstrap: [AppComponent]
})
export class AppModule {}
