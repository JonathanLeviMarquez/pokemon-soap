package com.bancaya.challenge.pokemon_soap.service;

import com.bancaya.challenge.pokemon_soap.model.dto.PokemonDTO;

//  Service interface for retreving Pokémon data from the  external PokeAPI
public interface PokemonService {
    PokemonDTO getPokemonByName(String name);
}
