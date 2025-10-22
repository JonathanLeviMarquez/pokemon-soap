package com.bancaya.challenge.pokemon_soap.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration //Marks this clas as SPring configuraition class
public class RestClientConfig {

    @Bean //Provides apre-configured Rest template bean for HTTP requests
    RestClient pokeApiClient(@Value("${pokeapi.base-url}") String baseUrl) {
        return RestClient.builder()
                .baseUrl(baseUrl)
                .build();
    }

}
