package com.bancaya.challenge.pokemon_soap.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;
// Enables Spring-WS  and marks this class as a web  service configuration
@EnableWs
@Configuration
//Registers the Spring-WS MessageDispatcherServlet  to handle SOAP  requests at /ws/**
public class WebServiceConfig {
    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext ctx) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(ctx);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(servlet, "/ws/*"); // endpoint base
    }

    //loads the Pokémon XSD schema from classpath to define soap message structure
    @Bean
    public XsdSchema pokemonSchema() {
        return new SimpleXsdSchema(new ClassPathResource("xsd/pokemon.xsd"));
    }

    // generates the WSDL 1.1 definition based on the loaded  schema
    @Bean(name = "pokemon")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema pokemonSchema) {
        DefaultWsdl11Definition wsdl = new DefaultWsdl11Definition();
        wsdl.setPortTypeName("PokemonPort");
        wsdl.setLocationUri("/ws");
        wsdl.setTargetNamespace("http://bancaya.com/challenge/pokemon");
        wsdl.setSchema(pokemonSchema);
        return wsdl;
    }

}
