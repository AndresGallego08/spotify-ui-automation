package com.castor.spotify.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/spotify",
        glue = "com.castor.spotify.steps",
        plugin = {"pretty"}
)
public class SpotifyTestSuite {}
