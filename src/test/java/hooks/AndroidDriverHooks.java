package hooks;

import config.ConfigConstructor;
import drivers.AndroidDriverInstance;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.IOException;

public class AndroidDriverHooks {

    ConfigConstructor config = new ConfigConstructor();

    @Before(value = "@Android", order = 0)
    public void initializeAndroidDriver() {
        AndroidDriverInstance.initialize(config);
    }

    @After(value = "@Android", order = 0)
    public void quitAndroidDriver(Scenario scenario) {
        if (scenario.isFailed()) {
            scenario.embed(((TakesScreenshot) AndroidDriverInstance.androidDriver)
                            .getScreenshotAs(OutputType.BYTES),
                    "image/png");
            scenario.write("Scenario Fail");
        }
        AndroidDriverInstance.quit();
    }
}
