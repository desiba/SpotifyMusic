package com.desmond.spotify.controllers;

import com.desmond.spotify.dto.UserDto;
import com.desmond.spotify.model.UserSummary;
import com.desmond.spotify.security.CurrentUser;
import com.desmond.spotify.security.UserPrincipal;
import com.desmond.spotify.services.UserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/me")
    public UserSummary getCurrentUser(@CurrentUser UserPrincipal currentUser) {
        UserSummary userSummary = new UserSummary(currentUser.getId(), currentUser.getUserId(), currentUser.getFirstname(), currentUser.getLastname(), currentUser.getEmail());
        return userSummary;
    }


    @GetMapping("/getAllUsers")
    public List<UserSummary> getAllUsers(@RequestParam(value = "page", defaultValue = "0") int page, @RequestParam(value = "limit", defaultValue = "2") int limit) {

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT);

        List<UserSummary> returnValue = new ArrayList<>();

        List<UserDto> users = userService.getUsers(page, limit);

        Type listType = new TypeToken<List<UserSummary>>() {}.getType();

        returnValue = modelMapper.map(users, listType);

        return returnValue;

    }


}
