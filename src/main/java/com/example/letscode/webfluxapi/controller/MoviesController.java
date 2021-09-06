package com.example.letscode.webfluxapi.controller;

import com.example.letscode.webfluxapi.domain.MoviesList;
import com.example.letscode.webfluxapi.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("movies")
public class MoviesController {

    @Autowired
    private MovieService movieService;

    @GetMapping()
    public Flux<MoviesList> getMoviesPopular(){
        return movieService.getMoviesPopular();
    }
}
