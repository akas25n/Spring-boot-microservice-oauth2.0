package com.albumsresourceserver.service;

import com.albumsresourceserver.model.Albums;
import com.albumsresourceserver.repository.AlbumsRepository;
import com.albumsresourceserver.response.AlbumsResponse;
import com.albumsresourceserver.response.PhotosResponse;
import org.modelmapper.ModelMapper;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class AlbumsService {

    private AlbumsRepository albumsRepository;
    private RestTemplate restTemplate;

    public AlbumsService(AlbumsRepository albumsRepository, RestTemplate restTemplate) {
        this.albumsRepository = albumsRepository;
        this.restTemplate = restTemplate;
    }

    public List<Albums> findAllAlbums() {
        return albumsRepository.findAll();
    }

    public Albums findAlbumsById(Long id) {
        return albumsRepository.findAlbumsById(id);
    }

    public Albums saveNewAlbum(Albums album) {
        return albumsRepository.save(album);
    }

    public void deleteAlbum(long id) {
        albumsRepository.deleteById(id);
    }

    public AlbumsResponse findAlbumsResponseById(long albumId) {
        Albums album = albumsRepository.findAlbumsById(albumId);

        AlbumsResponse albumsResponse = new ModelMapper().map(album, AlbumsResponse.class);

        String photosUrl = String.format("http://PHOTOS-R-SERVER/api/photos/%s", albumId);

        ResponseEntity<List<PhotosResponse>> photoListResponse = restTemplate.exchange(photosUrl, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<PhotosResponse>>() {});

        List<PhotosResponse> photosList = photoListResponse.getBody();
        albumsResponse.setPhotos(photosList);

        return albumsResponse;
    }
}
