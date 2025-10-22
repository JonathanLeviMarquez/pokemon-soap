package com.bancaya.challenge.pokemon_soap.bdd;



import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.ws.test.server.MockWebServiceClient;
import org.springframework.ws.test.server.ResponseActions;

import javax.xml.transform.stream.StreamSource;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.ws.test.server.RequestCreators.withPayload;
import static org.springframework.ws.test.server.ResponseMatchers.xpath;

public class SoapPokemonStepDefs {

    private final ApplicationContext applicationContext;
    private MockWebServiceClient client;
    private ResponseActions response;


    public SoapPokemonStepDefs(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }
    private static Map<String, String> ns() {
        Map<String, String> m = new HashMap<>();
        m.put("ns2", "http://bancaya.com/challenge/pokemon");
        return m;
    }

    @Given("the SOAP service is up in a test context")
    public void the_service_is_up() {
        client = MockWebServiceClient.createClient(applicationContext);
    }

    @When("I request the Pokemon with name {string}")
    public void i_request_the_pokemon_with_name(String name) {
        String request =
                "<ns:GetPokemonRequest xmlns:ns=\"http://bancaya.com/challenge/pokemon\">" +
                        "<ns:name>" + name + "</ns:name>" +
                        "</ns:GetPokemonRequest>";
        response = client.sendRequest(withPayload(new StreamSource(new StringReader(request))));
    }

    @Then("the SOAP response contains name {string}")
    public void the_response_contains_name(String expectedName) {
        response.andExpect(
                xpath("//ns2:GetPokemonResponse/ns2:name", ns()).evaluatesTo(expectedName)
        );
    }

    @Then("the SOAP response contains height > {int}")
    public void the_response_contains_height_gt(int min) {
        response.andExpect(
                xpath("//ns2:GetPokemonResponse/ns2:height[number(.) > " + min + "]", ns()).exists()
        );
    }

    @Then("the SOAP response contains weight > {int}")
    public void the_response_contains_weight_gt(int min) {
        response.andExpect(

                xpath("//ns2:GetPokemonResponse/ns2:weight[number(.) > " + min + "]", ns()).exists()
        );
    }

    @Then("the SOAP response contains baseExperience >= {int}")
    public void the_response_contains_base_experience_ge(int min) {
        response.andExpect(

                xpath("//ns2:GetPokemonResponse/ns2:baseExperience[number(.) >= " + min + "]", ns()).exists()
        );
    }
}
