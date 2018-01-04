package Pages;

import Utils.User;
import Utils.UserFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(xpath = "//input[@name='login']")
    private WebElement inputLogin;

    @FindBy(xpath = "//input[@name='pass']")
    private WebElement inputPassword;

    @FindBy(xpath = "//input[@tabindex='5']")
    private WebElement btnLogin;


    public void login (String name, String password){

        inputLogin.sendKeys(name);
        inputPassword.sendKeys(password);
        btnLogin.submit();
    }


    public void loginValidUser (){
        User user = UserFactory.getValidUser();
        login (user.getName(),user.getPassword());
    }

    public void loginInvalidUser (){
        User user = UserFactory.getInvalidUser();
        login (user.getName(),user.getPassword());
    }
}

