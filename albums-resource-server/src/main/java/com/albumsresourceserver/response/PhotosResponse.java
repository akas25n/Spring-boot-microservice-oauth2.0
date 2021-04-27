package com.albumsresourceserver.response;

import javax.persistence.*;

public class PhotosResponse {

    private String photoTitle;
    private String photoDescription;
    private String photoLocation;
    private String photoUrl;
    private long albumId;

    public PhotosResponse() {
    }

    public PhotosResponse(String photoTitle, String photoDescription, String photoLocation, String photoUrl) {
        this.photoTitle = photoTitle;
        this.photoDescription = photoDescription;
        this.photoLocation = photoLocation;
        this.photoUrl = photoUrl;
    }


    public String getPhotoTitle() {
        return photoTitle;
    }

    public void setPhotoTitle(String photoTitle) {
        this.photoTitle = photoTitle;
    }

    public String getPhotoDescription() {
        return photoDescription;
    }

    public void setPhotoDescription(String photoDescription) {
        this.photoDescription = photoDescription;
    }

    public String getPhotoLocation() {
        return photoLocation;
    }

    public void setPhotoLocation(String photoLocation) {
        this.photoLocation = photoLocation;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public PhotosResponse(long albumId) {
        this.albumId = albumId;
    }
}
