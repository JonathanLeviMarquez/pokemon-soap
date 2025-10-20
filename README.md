# pokemon-soap
This project is a Spring Boot application that consumes the public PokeAPI REST service and exposes selected data through SOAP web services. Each request made to the SOAP endpoint is logged into an embedded H2 database, storing metadata such as the client IP, method invoked, timestamp, and execution time.
