package com.castor.spotify.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

public class BrowsePlaylistsPage extends PageObject {

    /**
     * Hace scroll hasta la sección indicada por su aria-label,
     * por ejemplo: "Listas seleccionadas".
     */
    public void scrollToSection(String sectionLabel) {
        // Esperar a que exista la sección en el DOM
        waitForCondition().until(driver ->
                !findAll(By.xpath("//section[@aria-label='" + sectionLabel + "']")).isEmpty()
        );

        WebElementFacade section = find(By.xpath("//section[@aria-label='" + sectionLabel + "']"));
        evaluateJavascript("arguments[0].scrollIntoView(true);", section);
    }

    public boolean isPublicPlaylistVisible(String playlistName) {
        try {
            WebElementFacade publicLabel = find(By.xpath("//*[text()='Lista pública']"));
            WebElementFacade playlistTitle = find(By.xpath("//*[text()='" + playlistName + "']"));

            publicLabel.waitUntilVisible();
            playlistTitle.waitUntilVisible();

            return publicLabel.isDisplayed() && playlistTitle.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
