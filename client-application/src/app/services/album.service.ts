import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Album} from "../models/album";

@Injectable({
  providedIn: 'root'
})
export class AlbumService {

  private baseUrl = "http://localhost:8090/api/albums"

  constructor( private httpClient: HttpClient) { }

  public getAllAlbums(): Observable<Album[]>{
    return this.httpClient.get<Album[]>(`${this.baseUrl}`);
  }

  public createAlbum(album: Album): Observable<any>{
    return this.httpClient.post<Album>(`${this.baseUrl}`, album);
  }
}
