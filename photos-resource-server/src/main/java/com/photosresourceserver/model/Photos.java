package com.photosresourceserver.model;

import javax.persistence.*;

@Entity
@Table(name = "photos_TBL")
public class Photos {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;
    private String photoTitle;
    private String photoDescription;
    private String photoLocation;
    private String photoUrl;
    private long albumId;

    public Photos() {
    }

    public Photos(String photoTitle, String photoDescription, String photoLocation, String photoUrl, long albumId) {
        this.photoTitle = photoTitle;
        this.photoDescription = photoDescription;
        this.photoLocation = photoLocation;
        this.photoUrl = photoUrl;
        this.albumId = albumId;
    }

    public long getId() {
        return id;
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

    public long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(long albumId) {
        this.albumId = albumId;
    }
}
