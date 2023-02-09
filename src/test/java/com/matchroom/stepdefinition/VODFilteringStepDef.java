package com.matchroom.stepdefinition;

import com.matchroom.tests.VODFilteringTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class VODFilteringStepDef {

    @Steps
    VODFilteringTest vodFilteringTest;

    @Given("I am on OnDemand tab")
    public void i_am_on_on_demand_tab() {
        vodFilteringTest.launchURL();
    }

    @When("I select {string} as a sports filter")
    public void selectSportsFilter(String sports) {
        vodFilteringTest.selectSports(sports);
    }

    @Then("the only filtered {string} videos should be listed")
    public void filteredVideosListed(String sports) {
        vodFilteringTest.validateFilterResult(sports);
    }

    //---------------------------------
//    @And("length of video duration as {string}")
//    public void videoDurationFilter(String duration){
//        vodFilteringTest.validateVideoFilter(duration);
//    }

    @When("competition as {string}")
    public void competitionFilter(String competition) {
        vodFilteringTest.selectCompetitionFilter(competition);
    }

    @When("length of video duration as {string}")
    public void videoDurationFilter(String duration) {
        vodFilteringTest.selectTimeFilter(duration);
    }

    @When("I enter {string} into the search field")
    public void searchVideos(String searchTxt) {
        vodFilteringTest.searchVideos(searchTxt);
    }

}
