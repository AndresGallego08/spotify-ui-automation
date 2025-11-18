package com.castor.spotify.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageObject {

    @FindBy(xpath = "//span[normalize-space()='Recomendada para hoy']")
    private WebElementFacade webPlayerLink;

    public boolean isLoggedIn() {
        return waitFor(webPlayerLink).isDisplayed();
    }
}
