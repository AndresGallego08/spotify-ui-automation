package com.castor.spotify.steps;

import com.castor.spotify.pages.BrowsePlaylistsPage;
import com.castor.spotify.pages.HomePage;
import com.castor.spotify.pages.LoginPage;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.core.environment.ConfiguredEnvironment;
import net.thucydides.core.annotations.Steps;

import static org.junit.Assert.assertTrue;

public class BrowsePlaylistsSteps {

    @Steps
    LoginPage loginPage;

    @Steps
    HomePage homePage;

    @Steps
    BrowsePlaylistsPage browsePlaylistsPage;

    private String getValidEmail() {
        return ConfiguredEnvironment.getEnvironmentVariables()
                .getProperty("spotify.user.email");
    }

    private String getValidPassword() {
        return ConfiguredEnvironment.getEnvironmentVariables()
                .getProperty("spotify.user.password");
    }

    // Escenario: navegar a sección de playlists

    @Cuando("navego a la sección {string}")
    public void navego_a_la_seccion(String nombreSeccion) {
        browsePlaylistsPage.scrollToSection(nombreSeccion);
    }

    @Entonces("debería visualizar playlists públicas como {string}")
    public void deberia_visualizar_playlists_publicas_como(String nombrePlaylist) {
        assertTrue(
                "No se encontró la playlist pública esperada: " + nombrePlaylist,
                browsePlaylistsPage.isPublicPlaylistVisible(nombrePlaylist)
        );
    }
}
