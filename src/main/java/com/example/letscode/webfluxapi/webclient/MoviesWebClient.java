package com.example.letscode.webfluxapi.webclient;

import com.example.letscode.webfluxapi.constants.ConstantsCore;
import lombok.Getter;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
@Getter
public class MoviesWebClient {

    private final WebClient webClient;

    public MoviesWebClient(WebClient.Builder webclient){
        this.webClient = webclient.baseUrl(ConstantsCore.BASE_URL_LOCAL).build();
    }

}
