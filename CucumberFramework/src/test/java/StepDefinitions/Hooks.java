package StepDefinitions;

import io.cucumber.java.After;
import utilities.Driver;

public class Hooks {
    @After
    public void tearDown(){
        Driver.closeDriver();
    }
}
