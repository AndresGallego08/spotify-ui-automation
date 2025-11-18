package com.castor.spotify.steps;

import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Hook global para asegurar de que siempre se use
 * la versión correcta de ChromeDriver.
 */
public class WebDriverHooks {

    @Before(order = 0)
    public void configurarDriver() {
        // Descarga (si hace falta) y configura el ChromeDriver
        WebDriverManager.chromedriver().setup();
    }
}
