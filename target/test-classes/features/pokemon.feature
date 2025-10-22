Feature: Get basic data of a Pokémon via SOAP

  Background:
    Given the SOAP service is up in a test context

  Scenario: Query pikachu and get basic fields
    When I request the Pokemon with name "pikachu"
    Then the SOAP response contains name "pikachu"
    And the SOAP response contains height > 0
    And the SOAP response contains weight > 0
    And the SOAP response contains baseExperience >= 0