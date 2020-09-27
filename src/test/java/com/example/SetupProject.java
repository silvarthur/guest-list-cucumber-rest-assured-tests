package com.example;

import io.cucumber.java.Before;
import io.restassured.RestAssured;

public class SetupProject {
    @Before
    public void setup() {
        RestAssured.baseURI = "http://localhost:8080";
    }
}