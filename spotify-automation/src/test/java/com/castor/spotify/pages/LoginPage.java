package com.castor.spotify.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageObject {

    // PANTALLA 1: CORREO

    // Email input
    @FindBy(id = "username")
    private WebElementFacade emailField;

    // Botón “Continuar”
    @FindBy(css = "button[data-testid='login-button']")
    private WebElementFacade continueButton;

    // Mensaje: "Este correo o nombre de usuario no está asociado a ninguna cuenta de Spotify"
    @FindBy(xpath = "//*[text()='Este correo o nombre de usuario no está asociado a ninguna cuenta de Spotify']")
    private WebElementFacade invalidEmailError;


    // PANTALLA 2: ENLACE “Iniciar sesión con contraseña”

    @FindBy(xpath = "//button[normalize-space()='Iniciar sesión con contraseña']")
    private WebElementFacade loginWithPasswordButton;


    // PANTALLA 3: CONTRASEÑA

    // Password input
    @FindBy(id = "password")
    private WebElementFacade passwordField;

    // Mensaje: "Nombre de usuario o contraseña incorrectos."
    @FindBy(xpath = "//*[text()='Nombre de usuario o contraseña incorrectos.']")
    private WebElementFacade invalidPasswordError;


    // ====== NAVEGACIÓN ======

    public void openLoginPage() {
        openUrl("https://accounts.spotify.com/es/login");
    }

    // ACCIONES GENÉRICAS

    public void enterEmail(String email) {
        waitFor(emailField).clear();
        emailField.type(email);
    }

    public void clickContinue() {
        waitFor(continueButton).click();
    }

    public boolean isInvalidEmailErrorVisible() {
        return invalidEmailError.waitUntilVisible().isDisplayed();
    }

    public void clickLoginWithPassword() {
        waitFor(loginWithPasswordButton).click();
    }

    public void enterPassword(String password) {
        waitFor(passwordField).clear();
        passwordField.type(password);
    }

    public boolean isInvalidPasswordErrorVisible() {
        return invalidPasswordError.waitUntilVisible().isDisplayed();
    }
}
