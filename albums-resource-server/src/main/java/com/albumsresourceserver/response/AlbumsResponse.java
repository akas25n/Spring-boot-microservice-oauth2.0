package com.albumsresourceserver.response;

import java.util.List;

public class AlbumsResponse {

    private String albumTitle;
    private String albumDescription;
    private String albumImage;
    private List<PhotosResponse> photos;

    public AlbumsResponse() {
    }

    public AlbumsResponse(String albumTitle, String albumDescription, String albumImage, List<PhotosResponse> photos) {
        this.albumTitle = albumTitle;
        this.albumDescription = albumDescription;
        this.albumImage = albumImage;
        this.photos = photos;
    }

    public String getAlbumTitle() {
        return albumTitle;
    }

    public void setAlbumTitle(String albumTitle) {
        this.albumTitle = albumTitle;
    }

    public String getAlbumDescription() {
        return albumDescription;
    }

    public void setAlbumDescription(String albumDescription) {
        this.albumDescription = albumDescription;
    }

    public String getAlbumImage() {
        return albumImage;
    }

    public void setAlbumImage(String albumImage) {
        this.albumImage = albumImage;
    }

    public List<PhotosResponse> getPhotos() {
        return photos;
    }

    public void setPhotos(List<PhotosResponse> photos) {
        this.photos = photos;
    }
}
