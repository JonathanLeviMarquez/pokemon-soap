package com.bancaya.challenge.pokemon_soap.controller;

import com.bancaya.challenge.pokemon_soap.model.dto.PokemonDTO;
import com.bancaya.challenge.pokemon_soap.model.soap.GetPokemonRequest;
import com.bancaya.challenge.pokemon_soap.model.soap.GetPokemonResponse;
import com.bancaya.challenge.pokemon_soap.service.LogService;
import com.bancaya.challenge.pokemon_soap.service.PokemonService;
import com.bancaya.challenge.pokemon_soap.utils.Utils;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.concurrent.TimeUnit;

// Handles incoming SOAP requests for pokemon data
@Endpoint
public class PokemonEndpoint {

    private static final String NS = "http://bancaya.com/challenge/pokemon";
    private static final String METHOD = "GetPokemon";

    private final PokemonService pokemonService;
    private final LogService logService;
    public PokemonEndpoint(PokemonService pokemonService, LogService logService) {
        this.pokemonService = pokemonService;
        this.logService = logService;
    }

    //Process the getPokemonRequest SOAP message and returns basic Pokemon info
    @PayloadRoot(namespace = NS, localPart = "GetPokemonRequest")
    @ResponsePayload
    public GetPokemonResponse getPokemon(@RequestPayload GetPokemonRequest request) {
        long start = System.nanoTime();
        try {
            PokemonDTO dto = pokemonService.getPokemonByName(request.getName());

            GetPokemonResponse resp = new GetPokemonResponse();
            resp.setName(dto.name());
            resp.setHeight(dto.height());
            resp.setWeight(dto.weight());
            resp.setBaseExperience(dto.baseExperience());
            return resp;

        } finally {
            String clientIp = Utils.resolveClientIp();
            long elapsedMs = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - start);
            logService.save(clientIp, METHOD, elapsedMs);
        }
    }




}
