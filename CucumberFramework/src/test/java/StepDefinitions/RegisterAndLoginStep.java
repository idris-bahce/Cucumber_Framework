package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;
import utilities.Driver;

public class RegisterAndLoginStep extends BaseStep{
    @Given("Launch browser and land on the home page")
    public void launch_browser_and_land_on_the_home_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        String verifyingWord = Driver.getDriver().findElement(By.xpath("//li/a[@style='color: orange;']")).getText();
        Assert.assertEquals(verifyingWord,"Home");
    }

    @Then("click on login button and click delete button and verify that account deleted")
    public void click_on_login_button_and_click_delete_button_and_verify_that_account_deleted() {
        Driver.getDriver().findElement(By.cssSelector("a[href='/delete_account']")).click();
        BrowserUtils.waitForVisibility(By.cssSelector("h2[class='title text-center'] b"),2);
        String verifyingString = Driver.getDriver().findElement(By.cssSelector("h2[class='title text-center'] b")).getText();
        Driver.getDriver().findElement(By.cssSelector(".btn.btn-primary")).click();
        Assert.assertEquals(verifyingString,"ACCOUNT DELETED!");
    }
    @When("Click on login button and enter {string}")
    public void click_on_login_button_and_enter(String email) {
        pages.getHomePage().clickToSignupAndLoginButton();
        BrowserUtils.waitForVisibility(By.cssSelector("div[class='login-form'] h2"),2);
        pages.getLoginPage().sendEmail(email);
    }
    @When("enter password {string}")
    public void enter(String password) {
        pages.getLoginPage().sendPassword(String.valueOf(password));
        pages.getLoginPage().login();
        BrowserUtils.waitForVisibility(By.cssSelector("li:nth-child(10) a:nth-child(1)"),2);
        String verifyingString = Driver.getDriver().findElement(By.cssSelector("li:nth-child(10) a:nth-child(1)")).getText();
        Assert.assertEquals(verifyingString,"Logged in as idris");
    }
    @When("Click on login button and enter {string} and {string} and click signup button")
    public void click_on_login_button_and_enter_and_and_click_signup_button(String email, String name) {
        pages.getHomePage().navigateTo(" Signup / Login");
        pages.getSignupPage().writeEmail(name);
        pages.getSignupPage().writeName(email);
        pages.getSignupPage().clickSignupButton();
    }
    @When("verify {string}")
    public void verify(String string) {
        BrowserUtils.waitForVisibility(By.xpath("(//div/h2[@class='title text-center'])[1]"),2);
        Assert.assertEquals(string,"ENTER ACCOUNT INFORMATION");
    }
    @Then("select title man and fill details: {string}, DateOfBirth:{string} {string} {string}")
    public void select_title_man_and_fill_details_date_of_birth(String password, String day, String month, String year) {
        pages.getSignupPage().selectTitleMen();
        pages.getSignupPage().setPassword(password);
        pages.getSignupPage().setDateOfBirt(day,month,year);
    }
    @Then("Select checkbox Sign up for our newsletter and Receive special offers from our partners")
    public void select_checkbox_sign_up_for_our_newsletter_and_receive_special_offers_from_our_partners() {
        pages.getSignupPage().signupForOurNewsletterBox();
        pages.getSignupPage().receiveSpecialOffersFromOurTeamBox();
    }
    @Then("Fill details: {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void fill_details(String firstName, String last_name, String company, String address1, String address2,
                             String state, String city, String zipcode, String mobileNumber) {
        Driver.getDriver().findElement(By.id("first_name")).sendKeys(firstName);
        Driver.getDriver().findElement(By.id("last_name")).sendKeys(last_name);
        Driver.getDriver().findElement(By.id("company")).sendKeys(company);
        Driver.getDriver().findElement(By.id("address1")).sendKeys(address1);
        Driver.getDriver().findElement(By.id("address2")).sendKeys(address2);
        Driver.getDriver().findElement(By.id("state")).sendKeys(state);
        Driver.getDriver().findElement(By.id("city")).sendKeys(city);
        Driver.getDriver().findElement(By.id("zipcode")).sendKeys(zipcode);
        Driver.getDriver().findElement(By.id("mobile_number")).sendKeys(mobileNumber);
    }
    @Then("Click Create Account button and verify that {string} is visible")
    public void click_create_account_button_and_verify_that_is_visible(String string) {
        pages.getSignupPage().createAccountButton();
        BrowserUtils.waitForVisibility(By.cssSelector("h2[class='title text-center'] b"),2);
        Assert.assertEquals(string,"ACCOUNT CREATED!");
    }
    @Then("Click Continue button and verify that {string} is visible")
    public void click_continue_button_and_verify_that_is_visible(String string) {
        Driver.getDriver().findElement(By.cssSelector(".btn.btn-primary")).click();
        BrowserUtils.waitForVisibility(By.xpath("//li/a/i[@class='fa fa-user']/parent::a"),2);
        Assert.assertEquals(string,"Logged in as idris");
    }
}
