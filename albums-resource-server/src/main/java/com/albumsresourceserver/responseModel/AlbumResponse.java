package com.albumsresourceserver.responseModel;

import java.util.List;

public class AlbumResponse {

    private String albumTitle;
    private String albumDescription;
    public String albumCreatedOn;
    private String albumImage;
    private List<PhotoResponse> photos;

    public AlbumResponse() {
    }

    public AlbumResponse(String albumTitle, String albumDescription, String albumCreatedOn, String albumImage, List<PhotoResponse> photos) {
        this.albumTitle = albumTitle;
        this.albumDescription = albumDescription;
        this.albumCreatedOn = albumCreatedOn;
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

    public String getAlbumCreatedOn() {
        return albumCreatedOn;
    }

    public void setAlbumCreatedOn(String albumCreatedOn) {
        this.albumCreatedOn = albumCreatedOn;
    }

    public String getAlbumImage() {
        return albumImage;
    }

    public void setAlbumImage(String albumImage) {
        this.albumImage = albumImage;
    }

    public List<PhotoResponse> getPhotos() {
        return photos;
    }

    public void setPhotos(List<PhotoResponse> photos) {
        this.photos = photos;
    }
}
