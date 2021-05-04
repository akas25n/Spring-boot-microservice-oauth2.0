package com.albumsresourceserver.controller;

import com.albumsresourceserver.model.Album;
import com.albumsresourceserver.responseModel.AlbumResponse;
import com.albumsresourceserver.service.AlbumService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/api/albums")
@CrossOrigin(origins = "http://localhost:4200")
public class AlbumsController {

    private AlbumService albumService;

    public AlbumsController(AlbumService albumService, RestTemplate restTemplate) {
        this.albumService = albumService;
    }

    @GetMapping
    public List<Album> findAllAlbums(){
        return albumService.findAllAlbums();
    }

    //get all photos with album id
    @GetMapping("{albumId}/photos")
    public AlbumResponse getAlbumsIncludingPhotos(@PathVariable long albumId){
        AlbumResponse albumResponse = albumService.findAlbumsResponseById(albumId);
        return albumResponse;
    }

    @GetMapping("/{id}")
    public Album findAlbumsById(@PathVariable Long id){
        return albumService.findAlbumsById(id);
    }

    @PostMapping
    public Album saveNewAlbum(@RequestBody Album album){
        return albumService.saveNewAlbum(album);
    }

    @PutMapping("/{id}")
    public Album updateAlbum(@RequestBody Album newAlbum, @PathVariable long id){
        Album album = albumService.findAlbumsById(id);
        album.setAlbumDescription(newAlbum.getAlbumDescription());
        album.setAlbumTitle(newAlbum.getAlbumTitle());
        album.setAlbumImage(newAlbum.getAlbumImage());

        return albumService.saveNewAlbum(album);
    }

    @DeleteMapping("/{id}")
    public void deleteAlbum(@PathVariable long id){
        albumService.deleteAlbum(id);
    }

}
