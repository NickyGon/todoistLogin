package singletonSession;

import factoryBrowser.FactoryBrowser;
import org.openqa.selenium.WebDriver;

public class Session {

    private static Session session = null;
    private WebDriver browser;
    private Session(String browser){
        this.browser = FactoryBrowser.make(browser).create();
        //browser = FactoryBrowser.make("chrome").create();
        //browser = FactoryBrowser.make("edge").create();
    }

    public static Session getSession(String browName){
        if (session==null){
            session=new Session(browName);
        }
        return session;
    }

    public void closeBrowser(){
        session=null;
        browser.quit();
    }

    public void goTo(String url){
        browser.get(url);
    }

    public WebDriver getBrowser(){
        return browser;
    }
}
