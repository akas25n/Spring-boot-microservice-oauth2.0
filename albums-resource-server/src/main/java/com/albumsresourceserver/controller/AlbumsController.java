package com.albumsresourceserver.controller;

import com.albumsresourceserver.model.Albums;
import com.albumsresourceserver.response.AlbumsResponse;
import com.albumsresourceserver.service.AlbumsService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/api/albums")
public class AlbumsController {

    private AlbumsService albumsService;

    public AlbumsController(AlbumsService albumsService, RestTemplate restTemplate) {
        this.albumsService = albumsService;
    }

    @GetMapping
    public List<Albums> findAllAlbums(){
        return albumsService.findAllAlbums();
    }

    //get all photos with album id
    @GetMapping("{albumId}/photos")
    public AlbumsResponse getAlbumsIncludingPhotos(@PathVariable long albumId){
        AlbumsResponse albumsResponse = albumsService.findAlbumsResponseById(albumId);
        return albumsResponse;
    }

    @GetMapping("/{id}")
    public Albums findAlbumsById(@PathVariable Long id){
        return albumsService.findAlbumsById(id);
    }

    @PostMapping
    public Albums saveNewAlbum(@RequestBody Albums album){
        return albumsService.saveNewAlbum(album);
    }

    @PutMapping("/{id}")
    public Albums updateAlbum(@RequestBody Albums newAlbum, @PathVariable long id){

        Albums album = albumsService.findAlbumsById(id);

        album.setAlbumDescription(newAlbum.getAlbumDescription());
        album.setAlbumTitle(newAlbum.getAlbumTitle());
        album.setAlbumImage(newAlbum.getAlbumImage());

        return albumsService.saveNewAlbum(album);
    }

    @DeleteMapping("/{id}")
    public void deleteAlbum(@PathVariable long id){
        albumsService.deleteAlbum(id);
    }

}
