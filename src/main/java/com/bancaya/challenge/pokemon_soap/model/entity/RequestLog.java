package com.bancaya.challenge.pokemon_soap.model.entity;


import jakarta.persistence.*;
import java.time.OffsetDateTime;
import lombok.*;

//Entity for storing SOAP request logs in H2 database
@Entity
@Table(name = "request_log")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class RequestLog {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String clientIp;
    private String method;          // example: "GetPokemon"
    private long elapsedMs;         // whole execution time
    private OffsetDateTime timestamp;


}
