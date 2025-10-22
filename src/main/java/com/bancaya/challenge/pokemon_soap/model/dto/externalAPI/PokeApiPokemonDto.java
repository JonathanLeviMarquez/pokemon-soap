package com.bancaya.challenge.pokemon_soap.model.dto.externalAPI;
import com.fasterxml.jackson.annotation.JsonProperty;
//DTO for mapping pokeAPI JSON response (only needed fields)
public record PokeApiPokemonDto (
        String name,
        int height,
        int weight,
        @JsonProperty("base_experience") int baseExperience
){
}
