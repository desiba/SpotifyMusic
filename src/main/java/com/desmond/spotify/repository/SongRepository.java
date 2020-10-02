package com.desmond.spotify.repository;

import com.desmond.spotify.dto.SongDto;
import com.desmond.spotify.entities.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {




}
