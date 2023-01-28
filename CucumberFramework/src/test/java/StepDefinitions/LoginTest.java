package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;
import utilities.BrowserUtils;
import utilities.Driver;

public class LoginTest extends BaseStep{
    @Given("Launch browser and land on the home page")
    public void launch_browser_and_land_on_the_home_page() {
        String verifyingWord = Driver.getDriver().findElement(By.xpath("//li/a[@style='color: orange;']")).getText();
        Assert.assertEquals(verifyingWord,"Home");
    }
    @When("Click on login button and enter idris@idris123 and {int}")
    public void click_on_login_button_and_enter_idris_idris123_and(Integer int1) {
        pages.getHomePage().clickToSignupAndLoginButton();
        BrowserUtils.waitForVisibility(By.cssSelector("div[class='login-form'] h2"),2);
        pages.getLoginPage().sendEmail("idris@idris123");
        pages.getLoginPage().sendPassword(String.valueOf(int1));
        pages.getLoginPage().login();
        BrowserUtils.waitForVisibility(By.cssSelector("li:nth-child(10) a:nth-child(1)"),2);
        String verifyingString = Driver.getDriver().findElement(By.cssSelector("li:nth-child(10) a:nth-child(1)")).getText();
        Assert.assertEquals(verifyingString,"Logged in as bahce");
    }
    @Then("click on login button and click delete button and verify that account deleted")
    public void click_on_login_button_and_click_delete_button_and_verify_that_account_deleted() {
        Driver.getDriver().findElement(By.cssSelector("a[href='/delete_account']")).click();
        BrowserUtils.waitForVisibility(By.cssSelector("h2[class='title text-center'] b"),2);
        String verifyingString = Driver.getDriver().findElement(By.cssSelector("h2[class='title text-center'] b")).getText();
        Driver.getDriver().findElement(By.cssSelector(".btn.btn-primary")).click();
        Assert.assertEquals(verifyingString,"ACCOUNT DELETED!");
        Driver.closeDriver();
    }
}
