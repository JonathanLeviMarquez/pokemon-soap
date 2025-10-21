package com.bancaya.challenge.pokemon_soap.service.impl;


import com.bancaya.challenge.pokemon_soap.model.dto.PokemonDTO;
import com.bancaya.challenge.pokemon_soap.model.dto.externalAPI.PokeApiPokemonDto;
import com.bancaya.challenge.pokemon_soap.service.PokemonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;


@Service
@RequiredArgsConstructor
public class PokemonServiceImpl implements PokemonService {
    private final RestClient pokeApiClient;


    @Override
    public PokemonDTO getPokemonByName(String name) {
        try {
            //call external api  method:GET urL:/pokemon/{name}
            PokeApiPokemonDto p = pokeApiClient.get()
                    .uri(uri -> uri.path("/pokemon/{name}").build(name.toLowerCase()))
                    .retrieve()
                    .body(PokeApiPokemonDto.class);

            if (p == null) {
                throw new RestClientException("Empty body  from PokeAPI ");
            }

            return new PokemonDTO( p.name(), p.height(), p.weight() , p.baseExperience());

        } catch (HttpClientErrorException.NotFound e) {
            // {name} was not found
            throw new IllegalArgumentException("Pokemon not found: " + name);
        } catch (RestClientException e) {
            // network or parsing error
            throw new IllegalStateException("Error calling PokeAPI: " + e.getMessage(), e);
        }
    }


}
