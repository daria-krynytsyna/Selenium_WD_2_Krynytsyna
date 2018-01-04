package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MailPage extends BasePage {

	@FindBy(xpath="//span[@class='user_name']")
	private WebElement textUserName;

	@FindBy(xpath="//a[contains(.,'Создать письмо')]")
	private WebElement BtnCreateMail;

	@FindBy(xpath=".//*[@id='mesgList']/form/div")
	private List <WebElement> emails;

	@FindBy(xpath=".//*[@id='header_overall']/div[1]/ul[1]/li[1]/a")
	private WebElement BtnToHeader;

	@FindBy(xpath = ".//*[@title='выйти']")
	private WebElement BtnLogOut;

	public String getTextUserName (){
	return textUserName.getText();
	}

	public void createMail (){
	    BtnCreateMail.click();
    }

    public boolean findSubject(String expectedSubj){
		for (WebElement elem:emails) {
			String actualSubj = elem.getText();
			if (actualSubj.contains(expectedSubj)) {
				return true;
			}
		}
		return false;
	}

	}


