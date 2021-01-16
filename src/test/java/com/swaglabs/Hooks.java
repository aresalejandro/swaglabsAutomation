package com.swaglabs;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.swaglabs.core.DriverService;

public class Hooks {

    @Before
    public void beforeScenario(Scenario scenario) {
    }

    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            scenario.embed(((TakesScreenshot) DriverService
                    .getDriverInstance()).getScreenshotAs(OutputType.BYTES), "image/png");
        }
        DriverService.dismissDriver();
    }
}
