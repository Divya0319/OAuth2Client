package com.fastturtle.oauth2client.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "Hello, Home!";
    }

    @GetMapping("/secured")
    public String secured(Authentication authentication) {
        if(authentication != null && authentication.getPrincipal() instanceof OAuth2User) {
            OAuth2User oAuth2User = (OAuth2User) authentication.getPrincipal();
            String username = oAuth2User.getAttribute("name");
            String email = oAuth2User.getAttribute("email");
            return "Hello, "+ username + ", your mail id : " + email;
        }

        return "Hello secured. Unable to fetch user details.";
    }
}
