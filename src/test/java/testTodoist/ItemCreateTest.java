package testTodoist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import singletonSession.Session;
import utils.Properties;

import java.time.Duration;
import java.util.Date;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOfElementLocated;

public class ItemCreateTest extends TestBase{
    @ParameterizedTest
    @CsvSource({ "chrome","edge","firefox" })
    public void verifyCreateItem(String browser) throws InterruptedException {

        String newItem="NickItem"+new Date().getTime();
        login();
        createProject(browser);
        menuSection.addItemOption.click();
        itemSection.updateName(newItem,false);
        itemSection.accept.click();
        Thread.sleep(2000);

        Assertions.assertTrue(itemSection.currentItem.isControlDisplayed(),"ERROR, item not created!");

        try {
            itemSection.currentItem.click();
        } catch (Exception e){
            System.out.println("Caught not clickable button");
            WebDriverWait wait= new WebDriverWait(Session.getSession(browser).getBrowser(), Duration.ofSeconds(5));
            wait.until(ExpectedConditions.and(elementToBeClickable(By.xpath("(//ul[@class='items']//li//div[text()='"+newItem+"'])[last()]")),invisibilityOfElementLocated(By.xpath("//div[@data-testid=\"task-details-modal\"]"))));
            itemSection.currentItem.click();
        }

        String newItemUp="NikoItem"+new Date().getTime();
        itemSection.taskNameLabel.click();
        itemSection.updateName(newItemUp,true);
        itemSection.accept.click();
        Assertions.assertTrue(itemSection.taskNameLabel.getTextValue().contains(newItemUp),"ERROR, item not updated!");

        itemSection.editMenu.click();
        itemSection.deleteOption.click();
        itemSection.acceptModal.click();

        Assertions.assertFalse(itemSection.currentItem.isControlDisplayed(),"ERROR, item not deleted!");

    }

    public void login() throws InterruptedException {
        mainPage.loginButton.click();

        loginSection.emailTxtBox.setText(Properties.host);
        loginSection.pwdTxtBox.setText(Properties.pwd);
        menuSection.setEmail(Properties.host);
        loginSection.loginButton.click();
        Thread.sleep(2000);


    }

    public void createProject(String browser) throws InterruptedException{
        String newName="Nicknoo"+new Date().getTime();
        try {
            menuSection.projectLab.click();
        } catch (Exception e){
            System.out.println("Caught not clickable button");
            WebDriverWait wait= new WebDriverWait(Session.getSession(browser).getBrowser(), Duration.ofSeconds(5));
            wait.until(ExpectedConditions.and(elementToBeClickable(By.xpath("//div[@id='left_menu']//a[@href=\"/app/projects\"]")),invisibilityOfElementLocated(By.xpath("//div[contains(@class,'loading_screen')]"))));
            menuSection.projectLab.click();
        }
        Thread.sleep(2500);
        menuSection.createProjectLab.click();
        Thread.sleep(1000);
        projectModalSection.updateName(newName,false);
        menuSection.setNewprojectName(newName);
        projectModalSection.acceptModal.click();
        Thread.sleep(2500);


        Assertions.assertTrue(menuSection.newProjectLab.isControlDisplayed(), "ERROR, proyect not created!!");
    }
}
