export class AlbumResponse{
  albumTitle: string;
  albumDescription: string;
  albumCreatedOn: string;
  albumImage: string;
  photos: PhotoResponse[];
}

export class PhotoResponse {
  photoTitle: string;
  photoDescription: string;
  photoLocation: string;
  photoUrl: string;
  albumId: number;
}
