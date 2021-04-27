package com.photosresourceserver.service;

import com.photosresourceserver.model.Photo;
import com.photosresourceserver.repository.PhotoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhotoService {

    private PhotoRepository photoRepository;

    public PhotoService(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }

    public List<Photo> getAllPhotos() {
        return photoRepository.findAll();
    }

    public Photo saveNewPhoto(Photo photo) {
        return photoRepository.save(photo);
    }

    public void deletePhoto(long id) {
        photoRepository.deleteById(id);
    }

    public Photo findPhotoById(long id) {
        return photoRepository.findPhotoById(id);
    }

    public List<Photo> getPhotosByAlbumId(long albumId) {
        return photoRepository.getByAlbumId(albumId);
    }
}
