package testTodoist;

import factoryBrowser.Firefox;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import singletonSession.Session;
import utils.Properties;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOfElementLocated;

public class LoginTest extends TestBase{

    @ParameterizedTest
    @CsvSource({ "chrome", "edge","firefox" })
    public void verifyLoginSuccess(String browser) throws InterruptedException {

        mainPage.loginButton.click();

        loginSection.emailTxtBox.setText(Properties.host);
        loginSection.pwdTxtBox.setText(Properties.pwd);
        menuSection.setEmail(Properties.host);
        loginSection.loginButton.click();
        Thread.sleep(2000);


        try {
            menuSection.profile.click();
        } catch (Exception e){
            System.out.println("Caught not clickable button");
            WebDriverWait wait= new WebDriverWait(Session.getSession(browser).getBrowser(), Duration.ofSeconds(5));
            wait.until(ExpectedConditions.and(elementToBeClickable(By.id(":r2:")),invisibilityOfElementLocated(By.xpath("//div[contains(@class,'loading_screen')]"))));
            menuSection.profile.click();
        }
        Thread.sleep(2500);

        Assertions.assertTrue(menuSection.emaillabel.isControlDisplayed(),
                "ERROR!! login was not successfully, review credentials");
    }


}
