package com.photosresourceserver.service;

import com.photosresourceserver.model.Photos;
import com.photosresourceserver.repository.PhotosRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhotosService {

    private PhotosRepository photosRepository;

    public PhotosService(PhotosRepository photosRepository) {
        this.photosRepository = photosRepository;
    }

    public List<Photos> getAllPhotos() {
        return photosRepository.findAll();
    }

    public Photos saveNewPhoto(Photos photo) {
        return photosRepository.save(photo);
    }

    public void deletePhoto(long id) {
        photosRepository.deleteById(id);
    }

    public Photos findPhotoById(long id) {
        return photosRepository.findPhotoById(id);
    }

    public List<Photos> getPhotosByAlbumId(long albumId) {
        return photosRepository.getByAlbumId(albumId);
    }
}
