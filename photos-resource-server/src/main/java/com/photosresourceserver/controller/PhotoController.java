package com.photosresourceserver.controller;

import com.photosresourceserver.model.Photo;
import com.photosresourceserver.responseModel.PhotoResponse;
import com.photosresourceserver.service.PhotoService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/photos")
public class PhotoController {

    private PhotoService photoService;

    public PhotoController(PhotoService photoService) {
        this.photoService = photoService;
    }

    @GetMapping
    public List<Photo> getAllPhotos(){
        return photoService.getAllPhotos();
    }

    @GetMapping("/{albumId}")
    public List<PhotoResponse> albumsPhotos(@PathVariable long albumId){
        List<PhotoResponse> responses = new ArrayList<>();
        List<Photo> photos = photoService.getPhotosByAlbumId(albumId);

        if (photos == null || photos.isEmpty()){
            return responses;
        }

        Type listType = new TypeToken<List<PhotoResponse>>(){}.getType();

        responses = new ModelMapper().map(photos, listType);

        return responses;
    }

    @PostMapping("/{albumId}")
    public Photo insertNewPhoto(@RequestBody Photo newPhoto, @PathVariable long albumId){
        Photo photo = new Photo();

        photo.setPhotoTitle(newPhoto.getPhotoTitle());
        photo.setPhotoDescription(newPhoto.getPhotoDescription());
        photo.setPhotoLocation(newPhoto.getPhotoLocation());
        photo.setPhotoUrl(newPhoto.getPhotoUrl());
        photo.setAlbumId(albumId);
        return photoService.saveNewPhoto(photo);
    }

   @DeleteMapping("/{id}")
   public void deletePhoto(@PathVariable long id){
        photoService.deletePhoto(id);
   }
}
