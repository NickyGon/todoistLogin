package controls;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import singletonSession.Session;

public class ControlBase {
    protected By locator;
    protected WebElement control;

    public ControlBase (By locator){
        this.locator=locator;
    }
    private String browser;

    protected void findControl(){
        this.control = Session.getSession(this.browser).getBrowser().findElement(locator);
    }

    public void click(){
        this.findControl();
        this.control.click();
    }

    public boolean isControlDisplayed(){
        try {
            this.findControl();
            return this.control.isDisplayed();
        }catch (Exception e){
            return false;
        }
    }


    public String getTextValue(){
        this.findControl();
        return this.control.getText();
    }

    public String getTextByAttribute(String attr){
        this.findControl();
        return this.control.getAttribute(attr);
    }

    public void setMyBrowser(String browser){
        this.browser=browser;
    }
}
