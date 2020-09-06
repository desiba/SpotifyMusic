package com.desmond.spotify.controllers;

import com.desmond.spotify.request.ArtisteRequest;
import com.desmond.spotify.request.StoreSongRequest;
import com.desmond.spotify.services.ArtisteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/artiste")
public class ArtisteController {

    @Autowired
    ArtisteService artisteService;

    @PostMapping("/add_artiste")
    public void addArtiste(@Valid @RequestBody ArtisteRequest artisteRequest){
        System.out.println(artisteRequest.getFullName());
    }

    private void fetchAllArtists(){

    }

    private void getArtistGenre(){

    }

    private void getArtistById(){

    }

    private void getRandomArtist(){

    }

}
