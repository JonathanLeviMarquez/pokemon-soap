package com.bancaya.challenge.pokemon_soap.service;

// service interfae for saving log  entries of SOAP requests
public interface LogService {
    void save(String clientIp, String method, long elapsedMs);
}
