package pages.todoist;

import controls.Button;
import controls.Label;
import org.openqa.selenium.By;

public class MenuSection {

    public Button profile= new Button(By.id(":r2:"));

    public Label emaillabel = new Label(By.xpath("//div[contains(@style,'--popover')]//div//p[contains(text(),'@')]"));


    public void setEmail(String host) {
        emaillabel = new Label(By.xpath("//div[contains(@style,'--popover')]//div//p[text()='"+host+"']"));
    }
}
