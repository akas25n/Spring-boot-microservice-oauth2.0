package com.albumsresourceserver.model;

import javax.persistence.*;

@Entity
@Table(name = "albums_TBL")
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String albumTitle;
    private String albumDescription;
    public String albumCreatedOn;
    private String albumImage;

    public Album() {
    }

    public Album(String albumTitle, String albumDescription, String albumCreatedOn, String albumImage) {
        this.albumTitle = albumTitle;
        this.albumDescription = albumDescription;
        this.albumCreatedOn = albumCreatedOn;
        this.albumImage = albumImage;
    }

    public long getId() {
        return id;
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
}
