package pages.todoist;

import controls.Button;
import org.openqa.selenium.By;

public class MainPage {
    public Button loginButton = new Button(By.xpath("//div//ul//a[@href=\"/auth/login\"]"));
}
