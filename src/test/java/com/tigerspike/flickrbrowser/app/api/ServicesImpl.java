package com.tigerspike.flickrbrowser.app.api;

import com.jayway.restassured.response.Response;

import static com.jayway.restassured.RestAssured.given;

public class ServicesImpl implements Services{

    @Override
    public Response getRequest(String uri) {
       return given().contentType("application/json").when().get(uri);
    }


}
