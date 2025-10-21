package com.bancaya.challenge.pokemon_soap.model.soap;

import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "GetPokemonResponse")
@XmlType(propOrder = {"name","height","weight","baseExperience"})
public class GetPokemonResponse {
    private String name;
    private int height;
    private int weight;
    private int baseExperience;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getHeight() { return height; }
    public void setHeight(int height) { this.height = height; }
    public int getWeight() { return weight; }
    public void setWeight(int weight) { this.weight = weight; }
    public int getBaseExperience() { return baseExperience; }
    public void setBaseExperience(int baseExperience) { this.baseExperience = baseExperience; }
}
