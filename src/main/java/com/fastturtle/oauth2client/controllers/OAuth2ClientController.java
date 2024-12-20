package com.fastturtle.oauth2client.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//@RestController
public class OAuth2ClientController {

//    @GetMapping("/login/oauth2/code/custom-client")
    public String handleOAuth2Redirect(@RequestParam("code") String code) {
        return "Authorization code received: " + code;
    }

//    @GetMapping("/home")
    public String home() {
        return "Authorisation from OAuth2 server is successful";
    }
}
