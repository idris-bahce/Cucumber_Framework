package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;
import utilities.Driver;

public class StepTest_01 extends BaseStep{
    @Given("Launch browser and Navigate to url and Verify that home page is visible successfully")
    public void launch_browser_and_navigate_to_url_and_verify_that_home_page_is_visible_successfully() {
        String URL = ConfigurationReader.getProperty("url");
        String browser = ConfigurationReader.getProperty("browser");
        String environment = ConfigurationReader.getProperty("environment");
        Driver.getDriver().get(URL);
        System.out.println("::::::Test Information ::::::\n\tURL :" + URL + "\n\tBrowser :" + browser + "\n\tEnvironment :" + environment);
        BrowserUtils.wait(1);
        String verifyingWord = Driver.getDriver().findElement(By.xpath("//li/a[@style='color: orange;']")).getText();
        Assert.assertEquals(verifyingWord, "Home");
    }
    @When("Click on Signup  Login button Verify New User Signup! is visible")
    public void click_on_signup_login_button_verify_new_user_signup_is_visible() {
        pages.getHomePage().clickToSignupAndLoginButton();
        String verifyingString = Driver.getDriver().findElement(By.cssSelector("div[class='signup-form'] h2")).getText();
        Assert.assertEquals(verifyingString,"New User Signup!");
    }
    @And("Enter name and email address, Click Signup button and Verify that ENTER ACCOUNT INFORMATION is visible")
    public void enter_name_and_email_address_click_signup_button_and_verify_that_enter_account_information_is_visible() {
        pages.getSignupPage().writeEmail("idris@idris123");
        pages.getSignupPage().writeName("idris");
        pages.getSignupPage().clickSignupButton();
        BrowserUtils.waitForVisibility(By.xpath("(//div/h2[@class='title text-center'])[1]"),2);
        String verifyingString = Driver.getDriver().findElement(By.xpath("(//div/h2[@class='title text-center'])[1]")).getText();
        Assert.assertEquals(verifyingString,"ENTER ACCOUNT INFORMATION");
    }
    @Then("Fill details: Title, Name, Email, Password, Date of birth")
    public void fill_details_title_name_email_password_date_of_birth() {
        pages.getSignupPage().selectTitleMen();
        pages.getSignupPage().setPassword("123456");
        pages.getSignupPage().setDateOfBirt("4","May","1990");
    }
    @And("Select checkbox Sign up for our newsletter! and  Select checkbox Receive special offers from our partners")
    public void select_checkbox_sign_up_for_our_newsletter_and_select_checkbox_receive_special_offers_from_our_partners() {
        pages.getSignupPage().signupForOurNewsletterBox();
        pages.getSignupPage().receiveSpecialOffersFromOurTeamBox();
    }
    @Then("Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number")
    public void fill_details_first_name_last_name_company_address_address2_country_state_city_zipcode_mobile_number() {
        Driver.getDriver().findElement(By.id("first_name")).sendKeys("idris");
        Driver.getDriver().findElement(By.id("last_name")).sendKeys("ace");
        Driver.getDriver().findElement(By.id("company")).sendKeys("inar");
        Driver.getDriver().findElement(By.id("address1")).sendKeys("Cal sok. Silver aven.");
        Driver.getDriver().findElement(By.id("address2")).sendKeys("Cal sok. New aven.");
        Select select = new Select(Driver.getDriver().findElement(By.id("country")));
        select.selectByVisibleText("Canada");
        Driver.getDriver().findElement(By.id("state")).sendKeys("Ontario");
        Driver.getDriver().findElement(By.id("city")).sendKeys("Toronto");
        Driver.getDriver().findElement(By.id("zipcode")).sendKeys("03300");
        Driver.getDriver().findElement(By.id("mobile_number")).sendKeys("1425369875");
    }
    @Then("Click Create Account button and erify that ACCOUNT CREATED! is visible")
    public void click_create_account_button_and_erify_that_account_created_is_visible() {
        pages.getSignupPage().createAccountButton();
        BrowserUtils.waitForVisibility(By.cssSelector("h2[class='title text-center'] b"),2);
        String verifyingString = Driver.getDriver().findElement(By.cssSelector("h2[class='title text-center'] b")).getText();
        Assert.assertEquals(verifyingString,"ACCOUNT CREATED!");
        Driver.getDriver().close();
    }
}
