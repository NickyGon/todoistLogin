package pages.todoist;

import controls.Button;
import controls.TextBox;
import org.openqa.selenium.By;

public class ProjectModalSection {

    public TextBox nameProject= new TextBox(By.id("edit_project_modal_field_name"));
    public Button colorProject= new Button(By.xpath("//button[contains(@class,'color')]"));

    public Button colorOption=new Button(By.xpath("//div[contains(@class,'popper')]//li[@data-value=\"blue\"]"));
    public Button bluecolor= new Button(By.xpath("//div[contains(@class,'popper')]//li[@data-value=\"blue\"]"));
    public Button yellowcolor= new Button(By.xpath("//div[contains(@class,'popper')]//li[@data-value=\"yellow\"]"));


    public Button acceptModal = new Button(By.xpath("//footer//div//button[2]"));

    public void updateName(String name, boolean update){
        if (update){
            nameProject.clearSetText(name);
        } else {
            nameProject.setText(name);
        }
    }
}
