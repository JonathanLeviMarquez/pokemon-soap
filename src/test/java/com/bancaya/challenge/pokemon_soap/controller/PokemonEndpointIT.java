package com.bancaya.challenge.pokemon_soap.controller;

import com.bancaya.challenge.pokemon_soap.model.dto.PokemonDTO;
import com.bancaya.challenge.pokemon_soap.service.PokemonService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.ws.test.server.MockWebServiceClient;
import org.springframework.ws.test.server.RequestCreators;
import org.springframework.ws.test.server.ResponseMatchers;
import org.springframework.xml.transform.StringSource;

import static org.mockito.Mockito.when;

@SpringBootTest
public class PokemonEndpointIT {
    @Autowired
    private ApplicationContext applicationContext;
    @MockitoBean
    private PokemonService pokemonService;
    private MockWebServiceClient client;
    @BeforeEach
    void setUp() {
        client = MockWebServiceClient.createClient(applicationContext);
    }

    @Test
    void should_return_pokemon_basic_fields() {
        // Arrange
        when(pokemonService.getPokemonByName("pikachu"))
                .thenReturn(new PokemonDTO("pikachu", 4, 60, 112));

        // Request SOAP (usa StringSource, no necesitas importar javax.xml.transform.Source)
        var request = new StringSource("""
            <tns:GetPokemonRequest xmlns:tns="http://bancaya.com/challenge/pokemon">
              <tns:name>pikachu</tns:name>
            </tns:GetPokemonRequest>
        """);

        var expected = new org.springframework.xml.transform.StringSource("""
            <tns:GetPokemonResponse xmlns:tns="http://bancaya.com/challenge/pokemon">
              <tns:name>pikachu</tns:name>
              <tns:height>4</tns:height>
              <tns:weight>60</tns:weight>
              <tns:baseExperience>112</tns:baseExperience>
            </tns:GetPokemonResponse>
        """);

        // Act + Assert
        client.sendRequest(RequestCreators.withPayload(request))
                .andExpect(ResponseMatchers.payload(expected));
    }


}
