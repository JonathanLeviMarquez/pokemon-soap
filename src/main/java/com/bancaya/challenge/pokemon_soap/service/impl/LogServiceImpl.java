package com.bancaya.challenge.pokemon_soap.service.impl;

import com.bancaya.challenge.pokemon_soap.service.LogService;
import com.bancaya.challenge.pokemon_soap.model.entity.RequestLog;
import com.bancaya.challenge.pokemon_soap.repository.RequestLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.OffsetDateTime;

//Implementation of  LogService that stores request logs in the  H2 database
@Service
@RequiredArgsConstructor
public class LogServiceImpl implements LogService {
    private final RequestLogRepository repository;

    @Override
    public void save(String clientIp, String method, long elapsedMs) {
        RequestLog log = RequestLog.builder()
                .clientIp(clientIp)
                .method(method)
                .elapsedMs(elapsedMs)
                .timestamp(OffsetDateTime.now())
                .build();
        repository.save(log);
    }


}
