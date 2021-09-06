package com.example.letscode.webfluxapi;

import com.example.letscode.webfluxapi.service.MovieService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class WebfluxApiApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(WebfluxApiApplication.class, args);
        System.err.println(context.getBean(MovieService.class).getMoviesPopularWebClient().blockFirst());

    }
}
