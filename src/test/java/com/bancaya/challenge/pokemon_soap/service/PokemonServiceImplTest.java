package com.bancaya.challenge.pokemon_soap.service;
import com.bancaya.challenge.pokemon_soap.model.dto.PokemonDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PokemonServiceImplTest {
    @Autowired
    PokemonService service;

    @Test
    void getPokemonByName_ok() {
        PokemonDTO dto = service.getPokemonByName("pikachu");
        assertThat(dto.name()).isEqualToIgnoringCase("pikachu");
        assertThat(dto.height()).isGreaterThan(0);
    }

}
