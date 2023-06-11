package testTodoist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import singletonSession.Session;
import utils.Properties;

import java.time.Duration;
import java.util.Date;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOfElementLocated;

// ESTO no es para calificar, es para aprovechar de práctica personal el CRUD de projectos en Todoist
public class ProjectCreateTest extends TestBase{



    @ParameterizedTest
    @CsvSource({ "chrome","edge","firefox" })
    public void verifyLoginSuccess(String browser) throws InterruptedException {

        String newName="Nicknoo"+new Date().getTime();


        login();
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

        try {
            menuSection.newProjectLab.click();
        } catch (Exception e){
            System.out.println("Caught not clickable button");
            WebDriverWait wait= new WebDriverWait(Session.getSession(browser).getBrowser(), Duration.ofSeconds(5));
            wait.until(ExpectedConditions.and(elementToBeClickable(By.xpath("(//ul[@id=\"projects_list\"]//li//span[contains(text(),'"+newName+"')])[last()]")),invisibilityOfElementLocated(By.xpath("//form[@class=\"edit_project_modal__form\"]"))));
            menuSection.newProjectLab.click();
        }
        String newNameUp="Nicknoir"+new Date().getTime();

       menuSection.newProjectOptions.click();
        Thread.sleep(1000);
       menuSection.editProjectOption.click();
        Thread.sleep(2000);
        projectModalSection.updateName(newNameUp,true);
        menuSection.setNewprojectName(newNameUp);
        projectModalSection.acceptModal.click();
        Thread.sleep(2000);

        Assertions.assertTrue(menuSection.newProjectLab.isControlDisplayed(), "ERROR, project not updated!!");

        try {
            menuSection.newProjectLab.click();
        } catch (Exception e){
            System.out.println("Caught not clickable button");
            WebDriverWait wait= new WebDriverWait(Session.getSession(browser).getBrowser(), Duration.ofSeconds(5));
            wait.until(ExpectedConditions.and(elementToBeClickable(By.xpath("(//ul[@id=\"projects_list\"]//li//span[contains(text(),'"+newName+"')])[last()]")),invisibilityOfElementLocated(By.xpath("//form[@class=\"edit_project_modal__form\"]"))));
            menuSection.newProjectLab.click();
        }

        menuSection.newProjectOptions.click();
        Thread.sleep(1000);
        menuSection.deleteProjectOption.click();
        Thread.sleep(2000);
        projectModalSection.acceptModal.click();
        Thread.sleep(2000);
        Assertions.assertFalse(menuSection.newProjectLab.isControlDisplayed(), "ERROR, project not deleted!!");
    }

    public void login() throws InterruptedException {
        mainPage.loginButton.click();

        loginSection.emailTxtBox.setText(Properties.host);
        loginSection.pwdTxtBox.setText(Properties.pwd);
        menuSection.setEmail(Properties.host);
        loginSection.loginButton.click();
        Thread.sleep(2000);


    }
}
