package com.photosresourceserver.repository;

import com.photosresourceserver.model.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PhotoRepository extends JpaRepository<Photo, Long> {

    Photo findPhotoById(long id);
    List<Photo> getByAlbumId(long albumId);
}
