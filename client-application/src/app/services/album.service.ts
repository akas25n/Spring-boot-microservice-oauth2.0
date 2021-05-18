import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Album} from "../models/album";
import {AlbumResponse} from "../models/albumResponse";

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

  public deleteALbum(id: number): Observable<any>{
    return this.httpClient.delete(`${this.baseUrl}/${id}`);
  }

  public getSingleAlbum(id: number): Observable<any>{
    return this.httpClient.get<Album>(`${this.baseUrl}/${id}`);
  }

  public getAlbumWithPhotos(id: number): Observable<any>{
    return this.httpClient.get<AlbumResponse>(`${this.baseUrl}/${id}` +"/photos");
  }

}
