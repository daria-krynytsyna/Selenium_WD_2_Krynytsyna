package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MailinatorWelcomePage extends BasePage{

    @FindBy(xpath = "//*[@id='inboxfield']")
    private WebElement inboxField;

    @FindBy(xpath = "//*[@class='btn btn-dark']")
    private WebElement btnGo;

    public void login (String name){
        inboxField.sendKeys(name);
        btnGo.click();
    }



}
