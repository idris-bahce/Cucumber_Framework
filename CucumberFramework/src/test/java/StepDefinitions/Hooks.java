package StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;
import utilities.Driver;

public class Hooks {
    @Before
    public void setup(Scenario scenario) {
        String URL = ConfigurationReader.getProperty("url");
        String browser = ConfigurationReader.getProperty("browser");
        String environment = ConfigurationReader.getProperty("environment");
        Driver.getDriver().get(URL);
        System.out.println("::::::Test Information ::::::\n\tURL :" + URL
                + "\n\tBrowser :" + browser + "\n\tEnvironment :" + environment);
        BrowserUtils.wait(1);
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            TakesScreenshot takesSS = (TakesScreenshot) Driver.getDriver();
            final byte[] image = takesSS.getScreenshotAs(OutputType.BYTES);
            scenario.attach(image, "image/png", ":::: onTestFailure SCREENSHOT ::::  com.automationexercise");
        }
        Driver.closeDriver();
    }
}
