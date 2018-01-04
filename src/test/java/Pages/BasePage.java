package Pages;


//import Driver.MyDriver;

import Driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

  protected static WebDriver driver = DriverFactory.getDriver();


    public BasePage() {
        PageFactory.initElements(driver,this);
    }
}
