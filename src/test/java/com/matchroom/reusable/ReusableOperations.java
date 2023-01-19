package com.matchroom.reusable;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.JavascriptExecutor;

public class ReusableOperations extends PageObject {

    //Scroll down till the bottom of the page
    public void scrollToBottom() {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }
}
