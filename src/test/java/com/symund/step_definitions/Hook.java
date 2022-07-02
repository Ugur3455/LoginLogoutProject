package com.symund.step_definitions;

import com.symund.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hook {

    @After
    public void teardownScenarios(Scenario scenario){
        if (scenario.isFailed()){
            byte [] screenShot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenShot,"image/png",scenario.getName());
        }
        Driver.closeDriver();
    }


}
