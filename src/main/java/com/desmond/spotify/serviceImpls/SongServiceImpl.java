package com.desmond.spotify.serviceImpls;

import com.desmond.spotify.dto.SongDto;
import com.desmond.spotify.dto.UserDto;
import com.desmond.spotify.entities.Album;
import com.desmond.spotify.entities.Song;
import com.desmond.spotify.entities.User;
import com.desmond.spotify.exceptions.FileStorageException;
import com.desmond.spotify.repository.SongRepository;
import com.desmond.spotify.repository.UserRepository;
import com.desmond.spotify.services.SongService;
import com.desmond.spotify.share.FileStorageProperties;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class SongServiceImpl implements SongService {

    private final Path fileStorageLocation;

    @Autowired
    SongRepository songRepository;

    @Autowired
    public SongServiceImpl(FileStorageProperties fileStorageProperties) {
        this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir())
                .toAbsolutePath().normalize();

        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex) {

        }
    }

    @Override
    public String storeSong(MultipartFile file) {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            // Copy file to the target location (Replacing existing file with the same name)
            Path targetLocation = this.fileStorageLocation.resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

            return fileName;
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }

    @Override
    public SongDto createSong(SongDto songDto) {
        String fileName = StringUtils.cleanPath(songDto.getSongFile().getOriginalFilename());
        ModelMapper modelMapper = new ModelMapper();

        try {
            Song song = modelMapper.map(songDto, Song.class);

            if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            String fileExtension = "";
            try {
                fileExtension = fileName.substring(fileName.lastIndexOf("."));
            } catch(Exception e) {
                fileExtension = "";
            }

            Path targetLocation = this.fileStorageLocation.resolve(fileName);

            Files.copy(songDto.getSongFile().getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

            song.setFileType(fileExtension);
            song.setFileName(fileName);


            Song storedSongDetails = songRepository.save(song);
            SongDto returnValue = modelMapper.map(storedSongDetails, SongDto.class);

            return returnValue;
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }

    }

    @Override
    public String fetchSongsByName(String songName) {
        return null;
    }

    @Override
    public String fetchSongsByArtiste(String artiseName) {
        return null;
    }

    @Override
    public String fetchSongsByAlbum(String albumName) {
        return null;
    }

    @Override
    public String fetchAllSongs() {
        return null;
    }


}
