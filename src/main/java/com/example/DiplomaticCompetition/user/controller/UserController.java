package com.example.DiplomaticCompetition.user.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @GetMapping("/user")
    public ResponseEntity<?> getUserInfo(@AuthenticationPrincipal OAuth2User principal) {
        return ResponseEntity.ok(principal.getAttributes());
    }
}
