package com.example;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import java.util.HashMap;
import java.util.Map;

public class GetGuestByIDSteps {
    private String url;
    private Response response;

    @Given("A guest in the list of an event;")
    public void getGuestByIDSuccessfullySetup() {
        url = "api/v1/guest/{id}";
    }

    @When("The request that gets a guest by the ID is executed;")
    public void getGuestByIDSuccessfullyActions() {
        Map<String,Integer> pathParams = new HashMap<>();
        pathParams.put("id", 3);

        response = RestAssuredRequests.doGetRequestWithPathParams(url, pathParams);
    }

    @Then("Status code 200 must be returned when getting guest by ID;")
    public void getGuestByIDSuccessfullyStatusCodeAssertions() {
        Assert.assertEquals(HttpStatus.SC_OK, response.getStatusCode());
    }

    @And("An object containing all the information about the guest must be returned.")
    public void getGuestByIDSuccessfullyResponseBodyAssertions() {
        ResponseBody responseBody = response.getBody();

        Assert.assertNotNull(responseBody.jsonPath().getInt("id"));
        Assert.assertNotNull(responseBody.jsonPath().getString("name"));
        Assert.assertNotNull(responseBody.jsonPath().getString("address"));
        Assert.assertNotNull(responseBody.jsonPath().getString("phone"));
        Assert.assertNotNull(responseBody.jsonPath().getString("email"));
        Assert.assertNotNull(responseBody.jsonPath().getInt("extraInvitations"));
    }
}
