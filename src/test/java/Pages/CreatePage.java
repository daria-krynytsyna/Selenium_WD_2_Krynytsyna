package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreatePage extends BasePage {

    @FindBy(xpath = "//textarea[contains(@id,'to')]")
    private WebElement inputTo;

    @FindBy(xpath = "//input[@name='subject']")
    private WebElement inputSubject;

    @FindBy(xpath = "//textarea[@id='text']")
    private WebElement inputText;

    @FindBy(xpath = "//input[@name='send']")
    private WebElement sendBtn;

    @FindBy(xpath = "html/body/div[1]/div[4]/ul/li[2]/a")
            //"//a[contains(@href,'?_rand=1723686209')]")
    private WebElement inputMailsBtn;



    public void sendMail(String name, String subject, String text){
       inputTo.sendKeys(name);
       inputSubject.sendKeys(subject);
       inputText.sendKeys(text);
       sendBtn.click();
    }

    public void goToInputMails(){
        inputMailsBtn.click();
    }
}
