package com.matchroom.web.pages;

import com.matchroom.reusable.ReusableOperations;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;


public class VODFilteringWebPage extends ReusableOperations {

    @FindBy(xpath = "//*[@class='video']")
    public List<WebElementFacade> allVideos;

    @FindBy(xpath = "//div[@class='choices__item choices__item--selectable']")
    public WebElementFacade selectedSports;

    @FindBy(xpath = "//app-filters/form//label[contains(text(), 'Sport')]/following-sibling::div[@class='choices']")
    public WebElementFacade filterSportsList;

    @FindBy(xpath = "//button[contains(text(), 'OK, GOT IT!')]")
    public WebElementFacade cookiesButton;

    @FindBy(xpath = "//button[contains(text(), 'View more')]")
    public WebElementFacade viewMoreBtn;

    public void launch() {
        open();
        getDriver().manage().window().fullscreen();
    }

    public void acceptCookies() {
        cookiesButton.click();
    }

    public void selectSportsFilter(String sports) {
        filterSportsList.click();
        selectSports(sports);
    }

    public void selectSports(String sports) {
        WebElement sportsElement = getDriver().findElement(By.xpath("(//div[@class='choices__list']/div[contains(text(), \"" + sports + "\")])[1]"));
        sportsElement.click();
    }

    public String getSelectedSportsName() {
        return selectedSports.getTextContent();
    }

    public int getResultCount(String sports) {
        scrollToBottom();
        while (viewMoreBtn.isVisible()) {
            viewMoreBtn.click();
            scrollToBottom();
        }
        List<WebElement> filteredSportsResults = getDriver().findElements(By.xpath("//*[@class='video']//span[contains(text(), \"" + sports + "\")]"));
        return filteredSportsResults.size();
    }

    public int getAllVideoCount() {
        return allVideos.size();
    }

}
