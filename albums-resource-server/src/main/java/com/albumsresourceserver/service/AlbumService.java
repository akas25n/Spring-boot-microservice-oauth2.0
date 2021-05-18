package com.albumsresourceserver.service;

import com.albumsresourceserver.model.Album;
import com.albumsresourceserver.repository.AlbumRepository;
import com.albumsresourceserver.responseModel.AlbumResponse;
import com.albumsresourceserver.responseModel.PhotoResponse;
import org.modelmapper.ModelMapper;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class AlbumService {

    private AlbumRepository albumRepository;
    private RestTemplate restTemplate;

    public AlbumService(AlbumRepository albumRepository, RestTemplate restTemplate) {
        this.albumRepository = albumRepository;
        this.restTemplate = restTemplate;
    }

    public List<Album> findAllAlbums() {
        return albumRepository.findAll();
    }

    public Album findAlbumsById(Long id) {
        return albumRepository.findAlbumsById(id);
    }

    public Album saveNewAlbum(Album album) {
        return albumRepository.save(album);
    }

    public void deleteAlbum(long id) {
        albumRepository.deleteById(id);
    }

    public AlbumResponse findAlbumsResponseById(long albumId) {

        Album album = albumRepository.findAlbumsById(albumId);
        AlbumResponse albumResponse = new ModelMapper().map(album, AlbumResponse.class);
        String photosUrl = String.format("http://PHOTOS-R-SERVER/api/photos/%s", albumId);
        ResponseEntity<List<PhotoResponse>> photoListResponse = restTemplate.exchange(photosUrl, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<PhotoResponse>>() {});
        List<PhotoResponse> photosList = photoListResponse.getBody();
        albumResponse.setPhotos(photosList);
        return albumResponse;
    }
}
