package com.castor.spotify.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends PageObject {

    // Input de búsqueda (locator REAL: data-testid="search-input")
    @FindBy(css = "input[data-testid='search-input']")
    private WebElementFacade searchInput;

    // Resultado 1: artista Coldplay
    @FindBy(xpath = "//a[@title='Coldplay']")
    private WebElementFacade coldplayArtistLink;

    // Resultado 2: texto "Incluye a Coldplay"
    @FindBy(xpath = "//*[text()='Incluye a Coldplay']")
    private WebElementFacade includesColdplayText;

    // Abrir URL base sin login
    public void openHomePage() {
        openUrl("https://open.spotify.com/intl-es/");
    }

    // Buscar término
    public void search(String term) {
        waitFor(searchInput).clear();
        searchInput.typeAndEnter(term);
    }

    // Validar resultados
    public boolean isColdplayVisible() {
        try {
            return coldplayArtistLink.waitUntilVisible().isDisplayed()
                    || includesColdplayText.waitUntilVisible().isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
