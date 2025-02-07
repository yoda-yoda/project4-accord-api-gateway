package org.noteam.gatewayservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

import java.io.IOException;
import java.net.URI;

@RestController
@RequestMapping("/fallback")
public class FallbackController {

    @Value("${gateway.fallback-url}")
    private String fallbackUrl;

    @GetMapping("/oauth2")
    public Mono<Void> oauth2Fallback(ServerHttpResponse response) {
        response.setStatusCode(HttpStatus.FOUND);
        response.getHeaders().setLocation(URI.create(fallbackUrl + "?service=oauth2"));
        return response.setComplete();
    }

    @GetMapping("/spring")
    public Mono<Void> springFallback(ServerHttpResponse response) {
        response.setStatusCode(HttpStatus.FOUND);
        response.getHeaders().setLocation(URI.create(fallbackUrl + "?service=spring"));
        return response.setComplete();
    }

    @GetMapping("/go")
    public Mono<Void> goFallback(ServerHttpResponse response) {
        response.setStatusCode(HttpStatus.FOUND);
        response.getHeaders().setLocation(URI.create(fallbackUrl + "?service=go"));
        return response.setComplete();
    }

    @GetMapping("/signaling")
    public Mono<Void> signalingFallback(ServerHttpResponse response) {
        response.setStatusCode(HttpStatus.FOUND);
        response.getHeaders().setLocation(URI.create(fallbackUrl + "?service=signaling"));
        return response.setComplete();
    }

    @GetMapping("/prometheus")
    public Mono<Void> prometheusFallback(ServerHttpResponse response) {
        response.setStatusCode(HttpStatus.FOUND);
        response.getHeaders().setLocation(URI.create(fallbackUrl + "?service=prometheus"));
        return response.setComplete();
    }
}