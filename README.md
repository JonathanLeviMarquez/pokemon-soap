# POKEMON-SOAP
Spring Boot application that consumes the public **PokeAPI REST** service and exposes selected data through a **SOAP Web Service**.  
Each SOAP request is logged into an **H2 in-memory database**.

---
## Run the application
```bash
./mvnw spring-boot:run
# App running at http://localhost:8080
```

### WSDL
	•	URL: http://localhost:8080/ws/pokemon.wsdl
	•	Namespace: http://bancaya.com/challenge/pokemon
	•	Location URI: /ws
 
### Curl call
```shell
curl -s http://localhost:8080/ws \
  -H "Content-Type: text/xml" \
  -d @requestExamples/requestPikachuExample.xml
```

### Example SOAP Request
```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                  xmlns:tns="http://bancaya.com/challenge/pokemon">
  <soapenv:Header/>
  <soapenv:Body>
    <tns:GetPokemonRequest>
      <tns:name>pikachu</tns:name>
    </tns:GetPokemonRequest>
  </soapenv:Body>
</soapenv:Envelope>
```


### Example SOAP Response
```xml
<SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
  <SOAP-ENV:Body>
    <ns2:GetPokemonResponse xmlns:ns2="http://bancaya.com/challenge/pokemon">
      <ns2:name>pikachu</ns2:name>
      <ns2:height>4</ns2:height>
      <ns2:weight>60</ns2:weight>
      <ns2:baseExperience>112</ns2:baseExperience>
    </ns2:GetPokemonResponse>
  </SOAP-ENV:Body> 
</SOAP-ENV:Envelope>
```

## Project Structure
```text
pokemon-soap/
│
├── requestExamples/
│   └── requestPikachuExample.xml
│
├── src/
│   ├── main/
│   │   ├── java/com/bancaya/challenge/pokemon_soap/
│   │   │   ├── config/
│   │   │   ├── controller/
│   │   │   ├── model/
│   │   │   ├── repository/
│   │   │   ├── service/
│   │   │   ├── utils/
│   │   │   └── PokemonSoapApplication.java
│   │   │
│   │   └── resources/
│   │       ├── xsd/pokemon.xsd
│   │       └── application.properties
│   │
│   └── test/
│
├── target/
│
├── .gitignore
├── HELP.md
├── mvnw
├── mvnw.cmd
├── pom.xml
└── README.md
```

## H2 Database
	•	Console: http://localhost:8080/h2-console
	•	JDBC URL: jdbc:h2:mem:pokemon_db
	•	User: sa
	•	Password: sa
### Query basic example
```sql
SELECT * FROM REQUEST_LOG;
```

## Tests
```bash
./mvnw clean verify
```

## Author
```text
Jonathan Levi Márquez García
```
## Company
```text
Bancaya Java Backend Challenge 2025
```