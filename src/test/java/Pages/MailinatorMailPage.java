package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.concurrent.TimeUnit;

public class MailinatorMailPage extends BasePage {

    @FindBy(xpath = "//*[@class='all_message-min_datte all_message-min_datte-3 ng-binding']")
    private WebElement timeSubject;

    @FindBy(xpath = "//*[@title='FROM']")
    private WebElement sender;

    @FindBy(xpath = "//*[@class='all_message-min_text all_message-min_text-3']")
    private WebElement subject;

    @FindBy(xpath = "//*[@id='msg_body']")
    private WebElement frame;


    public String getTextSubject() {
        return subject.getText();
    }

    public String getTextSender() {
        return sender.getText();
    }

    public String getTextTime() {
        return timeSubject.getText();
    }

    public void clickMail() {
        subject.click();
    }

    ///  Does not work
    public boolean findBody(String expectedSubj) throws ScriptException, InterruptedException {

        //driver.switchTo().frame(1).findElement(By.cssSelector("body")).getAttribute("body");
/*WebElement frame = (WebElement)((JavascriptExecutor) driver)
        .executeScript("var frameObj = document.evaluate('/html/body', document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue.outerHTML;\n" +
        //" var frameContent = frameObj.contentWindow.document.body.outerHTML;\n" +
        " alert(\"frame content : \"+frameObj);" );
        /*ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine engine = scriptEngineManager.getEngineByName("JavaScript");

        Object eval = engine.eval(" <html> <head> </head> <body> <iframe id=\"msg_body\" name=\"msg_body\">...</iframe>\n" +
                "\n" +
                "<script type=\"text/javascript\">\n" +
                "    var iframeDoc;\n" +
                "    if (window.frames && window.frames.iframeId &&\n" +
                "        (iframeDoc = window.frames.iframeId.document)) {\n" +
                "        var iframeBody = iframeDoc.body;\n" +
                "        var ifromContent = iframeBody.innerHTML;\n" +
                "    }\n" +
                "</script> </body> </html>");
        System.out.println(eval);*/

        driver.switchTo().defaultContent();
        driver.switchTo().frame(1);
        Thread.sleep(400);
        String actualBody = driver.findElement(By.cssSelector("body")).getText();
        System.out.println(actualBody);
        if (actualBody.contains(expectedSubj)) {
            return true;
        }

        return false;
    }
}
