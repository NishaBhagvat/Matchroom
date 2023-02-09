package com.matchroom.tests;

import com.matchroom.web.pages.VODFilteringWebPage;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

public class VODFilteringTest {
    VODFilteringWebPage vodFilteringWebPage;

    @Step
    public void launchURL() {
        vodFilteringWebPage.launch();
        vodFilteringWebPage.acceptCookies();
    }

    @Step
    public void selectSports(String sports) {
        vodFilteringWebPage.selectSportsFilter(sports);
        Assert.assertEquals("Selected sport is not displayed", sports, vodFilteringWebPage.getSelectedSportsName());
    }

    @Step
    public void validateFilterResult(String sports) {
        Assert.assertEquals("All filtered videos are not valid", vodFilteringWebPage.getResultCount(sports), vodFilteringWebPage.getAllVideoCount());
    }

    //----------------------
//    @Step
//    public void validateVideoFilter(String duration){
//        vodFilteringWebPage.videoDurationFilter(duration);
//        Assert.assertTrue("Videos are not listed ", vodFilteringWebPage.verifyVideoDuration(duration));
//
//    }

    @Step
    public void selectCompetitionFilter(String competition) {
        vodFilteringWebPage.selectCompetition(competition);
        Assert.assertEquals("Selected competition is not displayed", competition, vodFilteringWebPage.getSelectedCompName());
        Assert.assertTrue("Correct URL is not there", vodFilteringWebPage.verifyCompetitionURL(competition));
    }

    @Step
    public void selectTimeFilter(String duration) {
        vodFilteringWebPage.videoDurationFilter(duration);
        Assert.assertTrue("Correct time is not selected", vodFilteringWebPage.validateTimeFilter(duration));
    }

    @Step
    public void searchVideos(String searchTxt) {
        vodFilteringWebPage.searchForVideos(searchTxt);
        Assert.assertTrue("Search parameter is not same", vodFilteringWebPage.searchQueryParameter(searchTxt));
    }

}
