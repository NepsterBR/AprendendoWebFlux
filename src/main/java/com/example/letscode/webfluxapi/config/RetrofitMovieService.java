package com.example.letscode.webfluxapi.config;

import com.example.letscode.webfluxapi.domain.MoviesList;
import com.example.letscode.webfluxapi.domain.v2.MoviesDetails;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RetrofitMovieService {

    @GET("movie/popular")
    Flux<MoviesList> getMoviesPopular(@Query("api_key") String api_key);

    @GET("movie/{id}")
    Mono<MoviesDetails> getMovieDetais(
            @Path("id") Integer id,
            @Query("api_key") String api_key);

}
