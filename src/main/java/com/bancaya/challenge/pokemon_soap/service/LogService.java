package com.bancaya.challenge.pokemon_soap.service;

public interface LogService {
    void save(String clientIp, String method, long elapsedMs);
}
