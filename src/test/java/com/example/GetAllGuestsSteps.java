package com.example;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.junit.Assert;

public class GetAllGuestsSteps {
    private String url;
    private Response response;

    @Given("The list of all guests;")
    public void getAllGuestsSuccessfullySetup() {
        url = "api/v1/guest";
    }

    @When("The request that gets all guest from the list is executed;")
    public void getAllGuestsSuccessfullyActions() {
        response = RestAssuredRequests.doGetRequest(url);
    }

    @Then("Status code 200 must be returned when getting all guests;")
    public void getAllGuestsSuccessfullyStatusCodeAssertions() {
        Assert.assertEquals(200, response.getStatusCode());
    }

    @And("An object containing all guests from the list must be returned.")
    public void getAllGuestsSuccessfullyResponseBodyAssertions() {
        ResponseBody responseBody = response.getBody();

        Assert.assertFalse(responseBody.jsonPath().getList("").isEmpty());;
    }
}
