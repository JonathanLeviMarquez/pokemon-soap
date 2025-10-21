package com.bancaya.challenge.pokemon_soap.model.soap;

import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "GetPokemonRequest")
@XmlType(propOrder = {"name"})
public class GetPokemonRequest {
    private String name;
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
