package org.noteam.gatewayservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/fallback")
public class FallbackController {

    @Value("${gateway.fallback-url}")
    private String fallbackUrl;

    @GetMapping("/oauth2")
    public void oauth2Fallback(HttpServletResponse response) throws IOException {
        response.sendRedirect(fallbackUrl + "?service=oauth2");
    }

    @GetMapping("/spring")
    public void springFallback(HttpServletResponse response) throws IOException {
        response.sendRedirect(fallbackUrl + "?service=spring");
    }

    @GetMapping("/go")
    public void goFallback(HttpServletResponse response) throws IOException {
        response.sendRedirect(fallbackUrl + "?service=go");
    }

    @GetMapping("/signaling")
    public void signalingFallback(HttpServletResponse response) throws IOException {
        response.sendRedirect(fallbackUrl + "?service=signaling");
    }

    @GetMapping("/prometheus")
    public void prometheusFallback(HttpServletResponse response) throws IOException {
        response.sendRedirect(fallbackUrl + "?service=prometheus");
    }

}
