package com.castor.spotify.steps;

import com.castor.spotify.pages.HomePage;
import com.castor.spotify.pages.LoginPage;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.core.environment.ConfiguredEnvironment;
import net.thucydides.core.annotations.Steps;

import static org.junit.Assert.assertTrue;

public class LoginSteps {

    @Steps
    LoginPage loginPage;

    @Steps
    HomePage homePage;

    private String getValidEmail() {
        return ConfiguredEnvironment.getEnvironmentVariables()
                .getProperty("spotify.user.email");
    }

    private String getValidPassword() {
        return ConfiguredEnvironment.getEnvironmentVariables()
                .getProperty("spotify.user.password");
    }

    // ===== ESCENARIO 1: Email inválido =====

    @Dado("que estoy en la página de login de Spotify Web")
    public void que_estoy_en_la_pagina_de_login() {
        loginPage.openLoginPage();
    }

    @Cuando("ingreso un correo inválido")
    public void ingreso_un_correo_invalido() {
        loginPage.enterEmail("correo.no@existe@gmail.com");
        loginPage.clickContinue();
    }

    @Entonces("debería mostrarse un mensaje indicando que el usuario no existe")
    public void deberia_mostrarse_mensaje_usuario_no_existe() {
        assertTrue("No se mostró el mensaje de error esperado",
                loginPage.isInvalidEmailErrorVisible());
    }

    // ===== ESCENARIO 2: Contraseña inválida =====

    @Cuando("ingreso un correo válido")
    public void ingreso_un_correo_valido() {
        loginPage.enterEmail(getValidEmail());
        loginPage.clickContinue();
    }

    @Cuando("avanzo a la pantalla de contraseña")
    public void avanzo_a_la_pantalla_de_contrasena() {
        loginPage.clickLoginWithPassword();
    }

    @Cuando("ingreso una contraseña inválida")
    public void ingreso_una_contrasena_invalida() {
        loginPage.enterPassword("XXXXXXXX");
        loginPage.clickContinue();
    }

    @Entonces("debería mostrarse un mensaje indicando que la contraseña es incorrecta")
    public void deberia_mostrarse_error_contrasena() {
        assertTrue("No se mostró el mensaje de contraseña incorrecta",
                loginPage.isInvalidPasswordErrorVisible());
    }

    // ===== ESCENARIO 3: Login exitoso =====

    @Cuando("ingreso mis credenciales válidas")
    public void ingreso_mis_credenciales_validas() {
        loginPage.enterEmail(getValidEmail());
        loginPage.clickContinue();
        loginPage.clickLoginWithPassword();
        loginPage.enterPassword(getValidPassword());
        loginPage.clickContinue();
        loginPage.clickContinueToWebPlayer();
    }

    @Entonces("debería visualizar la página principal de Spotify Web")
    public void deberia_visualizar_home() {
        assertTrue("No se visualiza la página principal después del login",
                homePage.isLoggedIn());
    }
}
