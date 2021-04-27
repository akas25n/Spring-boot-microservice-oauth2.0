package com.albumsresourceserver.repository;

import com.albumsresourceserver.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, Long> {

    Album findAlbumsById(Long id);
}
