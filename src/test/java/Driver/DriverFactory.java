package Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static Common.Constants.BASE_URL;

public class DriverFactory {
   public static WebDriver driver = null;
    public static WebDriver getDriver(){

           System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--start-maximized");
            driver = new ChromeDriver(chromeOptions);


            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get(BASE_URL);

       return driver;
   }

    public static void quitDriver(WebDriver driver){

        driver.quit();
    }
}
