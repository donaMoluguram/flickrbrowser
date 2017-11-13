package com.tigerspike.flickrbrowser.app.steps;

import com.jayway.restassured.response.Response;
import com.tigerspike.flickrbrowser.app.api.ServicesImpl;
import com.tigerspike.flickrbrowser.app.screen_objects.HomeScreen;
import com.tigerspike.flickrbrowser.app.screen_objects.ResultsScreen;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class SearchSteps {
    private HomeScreen homeScreen;
    private ResultsScreen resultsScreen;
    private ServicesImpl services;

    public SearchSteps(HomeScreen diHomeScreen, ResultsScreen diResultsScreen, ServicesImpl diServices) {
        this.homeScreen = diHomeScreen;
        this.resultsScreen = diResultsScreen;
        this.services = diServices;
    }

    @Given("^Iam home homePage$")
    public void i_home_homePage() {
        assertThat("check is app on home screen", homeScreen.isOnHomePage());
    }


    @When("^I search for feed \"([^\"]*)\"$")
    public void iSearchForFeed(String searchTerm) {
        homeScreen.doSearch(searchTerm);
    }

    @Then("^I validate ui results with an endpoint \"([^\"]*)\"$")
    public void i_validate_ui_results_with_an_endpoint(String uri) {
        List<String> uiResults = resultsScreen.getListOfTitleFeeds();

        Response response = services.getRequest(uri);
        List<String> apiResults = response.then().extract().path("items.title");

        assertThat("validate both ui and api results for search ", uiResults, is(equalTo(apiResults)));
    }
}
