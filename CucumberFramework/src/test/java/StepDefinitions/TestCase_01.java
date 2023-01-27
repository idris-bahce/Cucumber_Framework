package StepDefinitions;

import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.testng.Assert;
import utilities.Driver;

public class TestCase_01 extends BaseStep{

    @Given("Launch browser and Navigate to url and Verify that home page is visible successfully")
    public void launch_browser_and_navigate_to_url_and_verify_that_home_page_is_visible_successfully() {
        String verifyingWord = Driver.getDriver().findElement(By.xpath("//li/a[@style='color: orange;']")).getText();
        Assert.assertEquals(verifyingWord,"Home");
    }
}
