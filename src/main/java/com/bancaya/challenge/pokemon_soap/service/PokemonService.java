package com.bancaya.challenge.pokemon_soap.service;

import com.bancaya.challenge.pokemon_soap.model.dto.PokemonDTO;

public interface PokemonService {
    PokemonDTO getPokemonByName(String name);
}
