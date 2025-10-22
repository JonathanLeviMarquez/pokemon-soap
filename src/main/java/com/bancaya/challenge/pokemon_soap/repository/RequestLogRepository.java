package com.bancaya.challenge.pokemon_soap.repository;


import com.bancaya.challenge.pokemon_soap.model.entity.RequestLog;
import org.springframework.data.jpa.repository.JpaRepository;

// Repository interface for persisting RequestLog entities into the H2 database
public interface RequestLogRepository  extends JpaRepository<RequestLog, Long> { }
