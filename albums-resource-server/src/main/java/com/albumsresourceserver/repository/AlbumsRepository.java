package com.albumsresourceserver.repository;

import com.albumsresourceserver.model.Albums;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumsRepository extends JpaRepository<Albums, Long> {

    Albums findAlbumsById(Long id);
}
