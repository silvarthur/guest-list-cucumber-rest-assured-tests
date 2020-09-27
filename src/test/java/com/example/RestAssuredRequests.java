package com.example;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class RestAssuredRequests {
    public static Response doGetRequest(String url) {
        return
        given().
            contentType(ContentType.JSON).
        when().
            get(url).
        then().
            extract().response();
    }

    public static Response doGetRequestWithPathParams(String url, Map<String,Integer> pathParams) {
        return
        given().
            contentType(ContentType.JSON).
            pathParams(pathParams).
        when().
            get(url).
        then().
            extract().response();
    }

    public static Response doPostRequest(String url, Map<String,String> body) {
        return
            given().
                contentType(ContentType.JSON).
                body(body).
            when().
                post(url).
            then().
                extract().response();
    }
}
