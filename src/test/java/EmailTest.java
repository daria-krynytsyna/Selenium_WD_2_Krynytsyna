import Driver.DriverFactory;
import Pages.*;
import org.junit.*;
import org.junit.runners.MethodSorters;


import static Common.Constants.BASE_URL;
import static Common.Constants.MAILINATOR_URL;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmailTest {

    @AfterClass
    public static void tearDownClass() {
        DriverFactory.driver.quit();
    }

    @Before
    public void SetUp() {
        LoginPage login = new LoginPage();
        login.loginValidUser();
    }

    @After
    public void tearDown() {
        DriverFactory.driver.navigate().to(BASE_URL);
        MainPage main = new MainPage();
        main.logOut();
    }

    @Test
    public void test1EmailCheck() throws Exception {

        MailPage mail = new MailPage();
        mail.createMail();
        CreatePage create = new CreatePage();
        String subj = "Subject for test:" + System.currentTimeMillis();
        String body = "This is test e-mail";
        String address = System.currentTimeMillis() + "@mailinator.com";
        create.sendMail(address, subj, body);

        DriverFactory.driver.navigate().to(MAILINATOR_URL);
        MailinatorWelcomePage mailWelcome = new MailinatorWelcomePage();
        mailWelcome.login(address);

        MailinatorMailPage mailMail = new MailinatorMailPage();
        String expectedText = "moments ago";
        String actualText = mailMail.getTextTime();
        Assert.assertEquals("Mail is absent", expectedText, actualText);

    }

    @Test
    public void test2SubjSenderCheck() throws Exception {

        MailPage mail = new MailPage();
        mail.createMail();
        CreatePage create = new CreatePage();
        String subj = "Subject for test:" + System.currentTimeMillis();
        String body = "This is test e-mail";
        String address = System.currentTimeMillis() + "@mailinator.com";
        create.sendMail(address, subj, body);

        DriverFactory.driver.navigate().to(MAILINATOR_URL);
        MailinatorWelcomePage mailWelcome = new MailinatorWelcomePage();
        mailWelcome.login(address);

        MailinatorMailPage mailMail = new MailinatorMailPage();
        String expectedSender = "Daria";
        String actualSender = mailMail.getTextSender();
        String expectedSubject = subj;
        String actualSubject = mailMail.getTextSubject();
        Assert.assertEquals("Incorrect sender", expectedSender, actualSender);
        Assert.assertEquals("Incorrect subject", expectedSubject, actualSubject);

    }

    @Test
    public void test3BodyCheck() throws Exception {

        MailPage mail = new MailPage();
        mail.createMail();
        CreatePage create = new CreatePage();
        String subj = "Subject for test:" + System.currentTimeMillis();
        String body = "This is test e-mail";
        String address = System.currentTimeMillis() + "@mailinator.com";
        create.sendMail(address, subj, body);

        DriverFactory.driver.navigate().to(MAILINATOR_URL);
        MailinatorWelcomePage mailWelcome = new MailinatorWelcomePage();
        mailWelcome.login(address);

        MailinatorMailPage mailMail = new MailinatorMailPage();
        mailMail.clickMail();
        String expectedBody = body;

        Assert.assertTrue("Incorrect body", mailMail.findBody(expectedBody) );


    }


}
