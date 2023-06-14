package factoryBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class Chrome implements IBrowser{
    @Override
    public WebDriver create() {
        System.setProperty("webdriver.chrome.driver","src/test/resources/driver/chromedriver.exe");
        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--lang=en-US");
        WebDriver chrome = new ChromeDriver(opt);
        chrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        chrome.manage().window().maximize();
        return chrome;
    }
}
