package pages.todoist;

import controls.Button;
import controls.TextBox;
import org.openqa.selenium.By;

public class LoginSection {
    public TextBox emailTxtBox = new TextBox(By.xpath("//input[@type='email']"));
    public TextBox pwdTxtBox = new TextBox(By.xpath("//input[@type='password']"));
    public Button loginButton = new Button(By.xpath("//button[@type='submit']"));
}
