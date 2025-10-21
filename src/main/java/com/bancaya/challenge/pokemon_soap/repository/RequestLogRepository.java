package com.bancaya.challenge.pokemon_soap.repository;


import com.bancaya.challenge.pokemon_soap.model.entity.RequestLog;
import org.springframework.data.jpa.repository.JpaRepository;
public interface RequestLogRepository  extends JpaRepository<RequestLog, Long> { }
