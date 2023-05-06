package stepDefinitions;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class NavigationStep{

    private WebDriver driver;

    @Given("I am on the home page")
    public void i_am_on_the_home_page(){
        System.out.println("im in step 1");
        ChromeOptions options =  new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
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
        driver.quit();
    }

    @AfterStep
    public void addScreenshot(Scenario scenario){

        //validate if scenario has failed
        if(scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "image");
        }

    }
}