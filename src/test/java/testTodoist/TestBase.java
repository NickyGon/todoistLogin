package testTodoist;

import factoryBrowser.Firefox;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import pages.todoist.LoginSection;
import pages.todoist.MainPage;
import pages.todoist.MenuSection;
import singletonSession.Session;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase {

    protected MainPage mainPage= new MainPage();
    protected LoginSection loginSection = new LoginSection();
    protected MenuSection menuSection = new MenuSection();


    @BeforeEach
    public void openBrowser(){
        Session.getSession().goTo("http://todoist.com/");
    }

    @AfterEach
    public void closeBrowser(){
        Session.getSession().closeBrowser();
    }
}
