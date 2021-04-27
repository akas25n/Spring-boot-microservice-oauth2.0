package com.photosresourceserver.controller;

import com.photosresourceserver.model.Photos;
import com.photosresourceserver.response.PhotosResponse;
import com.photosresourceserver.service.PhotosService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/photos")
public class PhotosController {

    private PhotosService photosService;

    public PhotosController(PhotosService photosService) {
        this.photosService = photosService;
    }

    @GetMapping
    public List<Photos> getAllPhotos(){
        return photosService.getAllPhotos();
    }

    @GetMapping("/{albumId}")
    public List<PhotosResponse> albumsPhotos(@PathVariable long albumId){
        List<PhotosResponse> responses = new ArrayList<>();
        List<Photos> photos = photosService.getPhotosByAlbumId(albumId);

        if (photos == null || photos.isEmpty()){
            return responses;
        }

        Type listType = new TypeToken<List<PhotosResponse>>(){}.getType();

        responses = new ModelMapper().map(photos, listType);

        return responses;
    }

    @PostMapping
    public Photos insertNewPhoto(@RequestBody Photos photos){
        return photosService.saveNewPhoto(photos);
    }
    @PutMapping("/{id}")
    public Photos editPhoto(@RequestBody Photos photo, @PathVariable long id){
        Photos photos = photosService.findPhotoById(id);
        photos.setPhotoDescription(photo.getPhotoDescription());
        photos.setPhotoLocation(photo.getPhotoLocation());
        photos.setPhotoTitle(photo.getPhotoTitle());
        photos.setPhotoUrl(photo.getPhotoUrl());
        return photosService.saveNewPhoto(photos);
   }

   @DeleteMapping("/{id}")
   public void deletePhoto(@PathVariable long id){
        photosService.deletePhoto(id);
   }
}
