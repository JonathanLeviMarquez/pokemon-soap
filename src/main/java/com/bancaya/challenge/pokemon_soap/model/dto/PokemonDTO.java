package com.bancaya.challenge.pokemon_soap.model.dto;

//SImple immutable DTO exposed by the SOAP layer (used in responses)
public record PokemonDTO(String name, int height, int weight, int baseExperience) {}