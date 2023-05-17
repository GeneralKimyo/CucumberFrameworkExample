package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class NavigationStep{

    private WebDriver driver;
    public NavigationStep(BaseTest baseTest){
        this.driver = baseTest.getDriver();
    }

    @Given("I am on the home page")
    public void i_am_on_the_home_page(){

        driver.get("https://askomdch.com");
    }
    @When("I click on store menu link")
    public void i_click_on_store_menu_link(){
        By storeLink = By.cssSelector("#menu-item-1227>a");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(storeLink)).click();
    }
    @Then("I should see the store page")
    public void i_should_see_the_store_page(){
        String expectedUrl = "https://askomdch.com/store/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl,expectedUrl);
    }

    @When("I click on About menu link")
    public void i_click_on_about_menu_link(){
        By aboutLink = By.cssSelector("#menu-item-1232>a");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(aboutLink)).click();
    }
    @Then("I should see the About page")
    public void i_should_see_the_about_page(){
        String expectedUrl = "https://askomdch.com/about/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl,expectedUrl);
    }
    @And("I should see the About Us title")
    public void i_should_see_the_about_us_title(){
        String expectedTitle = "About Us";
        String actualTitle = driver.findElement(By.cssSelector("h1[class='has-text-align-center']")).getText();
        Assert.assertEquals(actualTitle,expectedTitle);
    }

}