package com.desmond.spotify.services;

import com.desmond.spotify.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public interface UserService extends UserDetailsService {

    UserDto createUser(UserDto user);

    List<UserDto> getUsers(int page, int limit);

}
