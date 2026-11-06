package pages;

import actionDriver.ActionDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckBox {

    WebDriver driver;
    private ActionDriver actionDriver;

    public CheckBox(WebDriver driver){
        this.driver=driver;
        this.actionDriver = new ActionDriver(driver);
        PageFactory.initElements(driver,this);

    }
    @FindBy(id = "menuform:j_idt40")
    public WebElement menuItems_ele;

    @FindBy(id = "menuform:m_checkbox")
    public WebElement checkBox_ele;

    @FindBy(xpath = "//table[@id='j_idt87:basic']//label")
    public List<WebElement> selectCheckBox_ele;

    public void CheckBoxAction(){

        actionDriver.click(menuItems_ele);
        actionDriver.click(checkBox_ele);

        for(WebElement element:selectCheckBox_ele){
            if(!(element.getText().equals("Others"))){
                element.click();
            }
        }
        for(int i =1;i<=selectCheckBox_ele.size();i++){

            boolean value =driver.findElement(By.xpath("(//table[@id='j_idt87:basic']//input)["+i+"]")).isSelected();
            System.out.println("CheckBox " +i+ " selected status is :"+value);
        }


    }
}
