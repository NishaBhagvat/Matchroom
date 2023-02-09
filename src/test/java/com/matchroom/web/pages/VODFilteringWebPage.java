package com.matchroom.web.pages;

import com.matchroom.reusable.ReusableOperations;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import java.net.URLDecoder;
import java.util.List;


public class VODFilteringWebPage extends ReusableOperations {

    @FindBy(xpath = "//app-card-video[@class='video']")
    public List<WebElementFacade> allVideos;

//    @FindBy(xpath = "//div[@class='choices__item choices__item--selectable']")
//    public WebElementFacade selectedSports;

    @FindBy(xpath = "//label[contains(text(), 'Sport')]/following-sibling::div[@role='listbox']")
    public WebElementFacade filterSportsList;

    @FindBy(xpath = "//label[contains(text(), 'Competition')]/following-sibling::div[@role='listbox']")
    public WebElementFacade filterCompetition;
    @FindBy(xpath = "//button[contains(text(), 'OK, GOT IT!')]")
    public WebElementFacade cookiesButton;

    @FindBy(xpath = "//button[contains(text(), 'View more')]")
    public WebElementFacade viewMoreBtn;

    @FindBy(xpath = "//*[contains(text(), 'No results found')]")
    public WebElementFacade noResultFoundText;

    @FindBy(xpath = "//div[@class=\"search-container\"]//input[@placeholder=\"Search in MatchroomLive…\"]")
    public WebElementFacade searchTextBox;

    public void launch() {
        open();
        getDriver().manage().window().fullscreen();
    }

    public void acceptCookies() {
        cookiesButton.click();
    }

    public void selectSportsFilter(String sports) {
        filterSportsList.click();
        selectSportsCompetition(sports);
    }

    public void selectSportsCompetition(String sports) {
        WebElement sportsElement = getDriver().findElement(By.xpath("(//div[@role='listbox']/div[contains(text(), \"" + sports + "\")])[1]"));
        sportsElement.click();
    }

//    public String getSelectedSportsName() {
//        return selectedSports.getTextContent();
//    }

    public String getSelectedSportsName() {
        Select dropdownSports = new Select(getDriver().findElement(By.xpath("//select[@formcontrolname='sport']")));
        return dropdownSports.getFirstSelectedOption().getAttribute("label");
    }

    public int getResultCount(String sports) {
        int totalFilterVideos = 0;
        if (!noResultFoundText.isVisible()) {
            scrollToLoadRecords();
            List<WebElement> filteredSportsResults = getDriver().findElements(By.xpath("//app-card-video[@class='video']//span[contains(text(), \"" + sports + "\")]"));
            totalFilterVideos = filteredSportsResults.size();
        }
        return totalFilterVideos;
    }

    public int getAllVideoCount() {
        int totalVideos = 0;
        if (!noResultFoundText.isVisible()) {
            totalVideos = allVideos.size();
        }
        return totalVideos;
    }

    // --------------------------------------
    public void selectCompetition(String competition) {
        filterCompetition.click();
        selectSportsCompetition(competition);
    }

    public String getSelectedCompName() {
        Select dropdownComp = new Select(getDriver().findElement(By.xpath("//select[@formcontrolname='competition']")));
        return dropdownComp.getFirstSelectedOption().getAttribute("label");
    }

    public boolean verifyCompetitionURL(String competition) {
        return URLDecoder.decode(getDriver().getCurrentUrl()).contains(competition);
    }

    public void videoDurationFilter(String videoDuration) {
        WebElement videoLength = getDriver().findElement(By.xpath("//label[contains(text(), \" Video Duration \")]/following-sibling::div//label[contains(text(), \"" + videoDuration + "\")]"));
        videoLength.click();
    }
//    public boolean validateTimeFilter(String duration){
//        switch(duration){
//            case "Short":
//                return getDriver().getCurrentUrl().contains(videoDuration.Short.getDuration());
//            case "Medium":
//                System.out.println("Medium: "+videoDuration.Medium.getDuration());
//                return getDriver().getCurrentUrl().contains(videoDuration.Medium.getDuration());
//            case "Long":
//                return getDriver().getCurrentUrl().contains(videoDuration.Long.getDuration());
//        }
//        return false;
//    }

    public void scrollToLoadRecords() {
        scrollToBottom();
        while (viewMoreBtn.isVisible()) {
            viewMoreBtn.click();
            scrollToBottom();
        }
    }

    public boolean validateTimeFilter(String videoDuration) {
        scrollToLoadRecords();
        List<WebElement> videoDurationRecords = getDriver().findElements(By.className("runtime"));
        int totalSeconds = 0;

        for (WebElement e : videoDurationRecords) {
            List<String> temp = List.of(e.getText().split(":"));
            if (temp.size() == 2) {
                totalSeconds = (Integer.parseInt(temp.get(0))) * 60 + Integer.parseInt(temp.get(1));
            } else {
                totalSeconds = (Integer.parseInt(temp.get(0))) * 3600 + (Integer.parseInt(temp.get(1)) * 60) + Integer.parseInt(temp.get(1));
            }
            System.out.println("totalSeconds -" + totalSeconds);
        }
        switch (videoDuration) {
            case "Short":
                return totalSeconds < 299;
            case "Medium":
                return totalSeconds > 300 && totalSeconds < 600;
            case "Long":
                return totalSeconds > 601;
            default:
                return false;
        }
    }

    public void searchForVideos(String sports) {
        searchTextBox.type(sports);
    }

    public Boolean searchQueryParameter(String searchTxt) {
        return URLDecoder.decode(getDriver().getCurrentUrl()).contains(searchTxt);
    }

}
