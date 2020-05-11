package com.desmond.spotify.serviceImpls;

import com.desmond.spotify.dto.UserDto;
import com.desmond.spotify.model.User;
import com.desmond.spotify.repository.UserRepository;
import com.desmond.spotify.services.UserService;
import com.desmond.spotify.share.Utils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    Utils utils;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }

    @Override
    public UserDto createUser(UserDto userDto) {

        ModelMapper modelMapper = new ModelMapper();

        User user = modelMapper.map(userDto, User.class);
        user.setFirstname(userDto.getFirstname());
        user.setLastname(userDto.getLastname());

        user.setUserId(utils.generateUserId(15));
        user.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));

        User storedUserDetails = userRepository.save(user);

        UserDto returnValue = modelMapper.map(storedUserDetails, UserDto.class);



        return returnValue;
    }
}
