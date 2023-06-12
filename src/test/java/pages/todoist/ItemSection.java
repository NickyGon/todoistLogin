package pages.todoist;

import controls.Button;
import controls.Label;
import controls.TextBox;
import org.openqa.selenium.By;

public class ItemSection {



    public TextBox taskName=new TextBox(By.xpath("//div[contains(@class,'content_field')]//div[@role='textbox']"));

    public Button accept= new Button(By.xpath("//div[contains(@class,'footer')]//button[@type=\"submit\"]"));

    public TextBox taskDesc=new TextBox(By.xpath("//div[contains(@class,'description')]//div[@role='textbox']"));

    public Label currentItem=new Label(By.xpath("//ul[@class='items']//li//div[text()=\"NickItem\"]"));

    public TextBox taskNameLabel=new TextBox(By.xpath("//div[@class=\"task-overview-main\"]//div[@role='button' and contains(@class,\"-content\")]"));

    public Button editMenu=new Button(By.xpath("//div[@data-dialog]//header//button[@aria-haspopup='menu']"));

    public Button deleteOption= new Button(By.xpath("//div[contains(@style,'popover')]//div//button//div[contains(text(),\"Eliminar tarea\")]"));

    public Button acceptModal = new Button(By.xpath("//footer//div//button[2]"));



    public TextBox taskNameUpdate=new TextBox(By.xpath("//p[text()='"+""+"']"));

    public void updateName(String name,boolean update){
        currentItem=new Label(By.xpath("(//ul[@class='items']//li//div[text()='"+name+"'])[last()]"));
        if (update){
            taskNameUpdate.setTextP(name,"//div[contains(@class,'content_field')]//div[@role='textbox']");
        } else {
            taskNameUpdate=new TextBox(By.xpath("//p[text()='"+name+"']"));
            taskName.setText(name);
        }
    }

}
