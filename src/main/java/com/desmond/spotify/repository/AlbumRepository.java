package com.desmond.spotify.repository;

import com.desmond.spotify.entities.Album;
import com.desmond.spotify.entities.Artiste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {

    Album save(Album album);
    //Album findByArtisteId(String artisteId);

    List<Album> findAllByArtisteId(String id);
}
