package factoryBrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Firefox implements IBrowser{
    @Override
    public WebDriver create() {
        //Para que encuentre el bin de Firefox hay que establecer la ruta del binary a mano
        //(depende de la localización de su ejecutable de Firefox)
        FirefoxOptions options= new FirefoxOptions();
        options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
        System.setProperty("webdriver.gecko.driver","src/test/resources/driver/geckodriver.exe");
        WebDriver firefox = new FirefoxDriver(options);
        firefox.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        firefox.manage().window().maximize();
        return firefox;
    }
}
