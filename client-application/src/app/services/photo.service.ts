import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {PhotoResponse} from "../models/albumResponse";
import {Observable} from "rxjs";
import {Photo} from "../models/photo";
import {Album} from "../models/album";

@Injectable({
  providedIn: 'root'
})
export class PhotoService {

  private baseUrl = "http://localhost:8090/api/photos";

  constructor(private httpClient: HttpClient) { }

  public addPhotos(photo: Photo, id: number): Observable<any>{
    return this.httpClient.post<Photo>(`${this.baseUrl}/${id}`,photo)
  }

}
