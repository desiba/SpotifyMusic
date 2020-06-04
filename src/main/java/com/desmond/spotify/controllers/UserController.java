package com.desmond.spotify.controllers;

import com.desmond.spotify.model.UserSummary;
import com.desmond.spotify.security.CurrentUser;
import com.desmond.spotify.security.UserPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @GetMapping("/me")
    public UserSummary getCurrentUser(@CurrentUser UserPrincipal currentUser) {
        UserSummary userSummary = new UserSummary(currentUser.getId(), currentUser.getUserId(), currentUser.getFirstname(), currentUser.getLastname(), currentUser.getEmail());
        return userSummary;
    }



}
