package com.tigerspike.flickrbrowser.app.api;

import com.jayway.restassured.response.Response;

public interface Services {

    Response getRequest(String uri);

}
