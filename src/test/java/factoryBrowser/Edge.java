package factoryBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class Edge implements IBrowser{
    @Override
    public WebDriver create() {

        System.setProperty("webdriver.edge.driver","src/test/resources/driver/msedgedriver.exe");
        WebDriver edge = new EdgeDriver();
        edge.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        edge.manage().window().maximize();
        return edge;
    }
}
