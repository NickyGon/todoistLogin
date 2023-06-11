package testTodoist;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import pages.todoist.LoginSection;
import pages.todoist.MainPage;
import pages.todoist.MenuSection;
import pages.todoist.ProjectModalSection;
import singletonSession.Session;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class TestBase {

    protected MainPage mainPage= new MainPage();
    protected LoginSection loginSection = new LoginSection();
    protected MenuSection menuSection = new MenuSection();

    protected ProjectModalSection projectModalSection= new ProjectModalSection();

    static List<String> browser= new ArrayList<>();

    @BeforeAll
    public static void setup(){
        browser.add("chrome");
        browser.add("edge");
        browser.add("firefox");
    }

    @BeforeEach
    public void openBrowser(){
        System.out.println(browser);
        Session.getSession(browser.get(0)).goTo("http://todoist.com/");
    }

    @AfterEach
    public void closeBrowser(){
        Session.getSession(browser.get(0)).closeBrowser();
        if (browser.size()>1){
            browser.remove(0);
        }
    }
}
