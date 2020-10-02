package com.desmond.spotify.repository;

import com.desmond.spotify.entities.Artiste;
import com.desmond.spotify.entities.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtisteRepository extends JpaRepository<Artiste, Long> {
    Artiste findByArtisteId(String artisteId);
}
