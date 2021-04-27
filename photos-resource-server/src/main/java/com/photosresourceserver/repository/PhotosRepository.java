package com.photosresourceserver.repository;

import com.photosresourceserver.model.Photos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PhotosRepository extends JpaRepository<Photos, Long> {

    Photos findPhotoById(long id);
    List<Photos> getByAlbumId(long albumId);
}
