package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class BaseTest {

     public WebDriver getDriver() {
          return driver;
     }

     public void setDriver(WebDriver driver) {
          this.driver = driver;
     }

     private WebDriver driver;

     @Before
     public void startDriver(){
          ChromeOptions options =  new ChromeOptions();
          options.addArguments("--remote-allow-origins=*");
          driver = new ChromeDriver(options);
          setDriver(driver);
     }
     @After
     public void quitDriver(){
          getDriver().quit();
     }


     @AfterStep
     public void addScreenshot(Scenario scenario){

          //validate if scenario has failed
          if(scenario.isFailed()) {
               final byte[] screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
               scenario.attach(screenshot, "image/png", "image");
          }
     }

}
