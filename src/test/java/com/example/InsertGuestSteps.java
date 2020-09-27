package com.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import java.util.HashMap;
import java.util.Map;

public class InsertGuestSteps {
    String url;
    Response response;

    @Given("A person to be added to the list of guests;")
    public void insertNewGuestSuccessfullySetup() {
        url = "api/v1/guest";
    }

    @When("The request that inserts a guest to the list is executed;")
    public void insertNewGuestSuccessfullyActions() {
        Map<String,String> body = new HashMap<>();

        body.put("name", "new user");
        body.put("address", "new user's address, 123");
        body.put("phone", "11233334444");
        body.put("email", "user@teste.com");
        body.put("extraInvitations", "10");

        response = RestAssuredRequests.doPostRequest(url, body);
    }
    @Then("The new guest must be added to the list successfully.")
    public void insertNewGuestSuccessfullyStatusCodeAssertions() {
        Assert.assertEquals(HttpStatus.SC_OK, response.getStatusCode());
    }

}
