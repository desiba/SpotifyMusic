package com.desmond.spotify.controllers;

import com.desmond.spotify.dto.SongDto;
import com.desmond.spotify.dto.UserDto;
import com.desmond.spotify.request.SignUpRequest;
import com.desmond.spotify.request.StoreSongRequest;
import com.desmond.spotify.response.ApiResponse;
import com.desmond.spotify.response.UploadFileResponse;
import com.desmond.spotify.services.SongService;
import com.desmond.spotify.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/song")
public class SongController {

    @Autowired
    SongService songService;

    @PostMapping("/uploadsong")
    public UploadFileResponse uploadSong(@Valid @RequestBody StoreSongRequest storeSongRequest){

        ModelMapper modelMapper = new ModelMapper();

        SongDto songDto = modelMapper.map(storeSongRequest, SongDto.class);

        SongDto storedSong = songService.createSong(songDto);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/songsFile/")
                .path(storedSong.getSongName())
                .toUriString();

        return new UploadFileResponse(storedSong.getSongName(), fileDownloadUri, storedSong.getFileType(), storedSong.getFileSize());
    }
 /*
    @PostMapping("/uploadMultipleFiles")
    public List<UploadFileResponse> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
        return Arrays.asList(files)
                .stream()
                .map(file -> uploadSong(file))
                .collect(Collectors.toList());
    }
  */

}
