package com.example.letscode.webfluxapi.controller;

import com.example.letscode.webfluxapi.domain.v2.MoviesDetails;
import com.example.letscode.webfluxapi.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("movie")
public class MovieDetailsController {

    @Autowired
    private MovieService movieService;

    @GetMapping("{id}")
    public Mono<MoviesDetails> getMovieDetails(@PathVariable Integer id){
        return movieService.getMovieDetails(id);
    }
}
