package com.desmond.spotify.controllers;

import com.desmond.spotify.dto.ArtisteDto;
import com.desmond.spotify.entities.Artiste;
import com.desmond.spotify.request.ArtisteRequest;
import com.desmond.spotify.response.ArtisteResponse;
import com.desmond.spotify.services.ArtisteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/artiste")
public class ArtisteController {

    @Autowired
    ArtisteService artisteService;

    @Autowired
    ModelMapper modelMapper;


    @PostMapping("/add_artiste")
    public ArtisteResponse addArtiste(@Valid @RequestBody ArtisteRequest artisteRequest){

        ArtisteDto artisteDto = modelMapper.map(artisteRequest, ArtisteDto.class);

        ArtisteDto artiste = artisteService.addArtiste(artisteDto);

        return new ArtisteResponse(artiste.getArtisteId(),
                                    artiste.getFullName(),
                                    artiste.getStageName()
        );

    }

    private void fetchAllArtists(){

    }

    private void getArtistGenre(){

    }

    @GetMapping("/{artiste_id}")
    public ArtisteResponse getArtistById(@PathVariable("artiste_id") String id){

       ArtisteDto artiste = artisteService.getArtisteById(id);

       ArtisteResponse artisteResponse = new ArtisteResponse(
               artiste.getArtisteId(),
               artiste.getFullName(),
               artiste.getStageName()
       );
       return artisteResponse;
    }

    private void getRandomArtist(){

    }

}
