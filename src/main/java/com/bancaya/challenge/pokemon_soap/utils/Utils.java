package com.bancaya.challenge.pokemon_soap.utils;

import org.springframework.ws.transport.context.TransportContextHolder;
import org.springframework.ws.transport.http.HttpServletConnection;

public class Utils {
    public static String resolveClientIp() {
        try {
            HttpServletConnection conn =
                    (HttpServletConnection) TransportContextHolder.getTransportContext().getConnection();
            var req = conn.getHttpServletRequest();
            String xff = req.getHeader("X-Forwarded-For");
            if (xff != null && !xff.isBlank()) {
                return xff.split(",")[0].trim();
            }
            return req.getRemoteAddr();
        } catch (Exception e) {
            return "unknown";
        }
    }
}
