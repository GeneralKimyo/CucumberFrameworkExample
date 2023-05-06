package Base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

     public WebDriver getDriver() {
          return driver;
     }

     public void setDriver(WebDriver driver) {
          this.driver = driver;
     }

     private WebDriver driver;

     @BeforeMethod
     public void startDriver(){


     }

}
