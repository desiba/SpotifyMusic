package com.desmond.spotify.controllers;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    public void getCurrentUser(){
        System.out.println("current user");
    }



}
