package com.example.letscode.webfluxapi.service;

import com.example.letscode.webfluxapi.config.RetrofitInitializer;
import com.example.letscode.webfluxapi.config.RetrofitMovieService;
import com.example.letscode.webfluxapi.constants.ConstantsCore;
import com.example.letscode.webfluxapi.domain.MoviesList;
import com.example.letscode.webfluxapi.domain.v2.MoviesDetails;
import com.example.letscode.webfluxapi.webclient.MoviesWebClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import retrofit2.Retrofit;

@Service
public class MovieService {

    private final Retrofit retrofit;

    @Autowired
    private final MoviesWebClient moviesWebClient;

    public MovieService(MoviesWebClient moviesWebClient){
        this.moviesWebClient = moviesWebClient;
        this.retrofit = RetrofitInitializer.getRetrofit();
    }

    public Flux<MoviesList> getMoviesPopular(){
        return this.retrofit.create(RetrofitMovieService.class).getMoviesPopular(ConstantsCore.API_KEY);
    }

    public Mono<MoviesDetails> getMovieDetails(Integer id){
        return this.retrofit.create(RetrofitMovieService.class).getMovieDetais(id, ConstantsCore.API_KEY);
    }

    public Flux<String> getMoviesPopularWebClient(){
        return moviesWebClient.getWebClient().get().uri("movies").accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(MoviesList.class)
                .map(MoviesList::getItemCount);
    }
}
