package com.castor.spotify.steps;

import com.castor.spotify.pages.SearchPage;
import net.thucydides.core.annotations.Steps;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;

import static org.junit.Assert.assertTrue;

public class SearchSteps {

    @Steps
    SearchPage searchPage;

    @Dado("que estoy en la página principal de Spotify Web")
    public void abrirSpotify() {
        searchPage.openHomePage();
    }

    @Cuando("busco el término {string}")
    public void busco_el_termino(String termino) {
        searchPage.search(termino);
    }

    @Entonces("debería visualizar resultados relacionados con {string}")
    public void deberia_visualizar_resultados(String termino) {
        assertTrue("No se encontraron resultados relacionados con " + termino,
                searchPage.isColdplayVisible());
    }
}
