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
}
