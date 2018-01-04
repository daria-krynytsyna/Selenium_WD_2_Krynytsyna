package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {
    @FindBy(xpath = "//*[@title ='выйти']")
    private WebElement btnLogOut;

    public void logOut(){
        btnLogOut.click();
    }

}
