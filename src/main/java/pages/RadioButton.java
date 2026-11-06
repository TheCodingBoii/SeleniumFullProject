package pages;

import actionDriver.ActionDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class RadioButton {
     WebDriver driver;
     private ActionDriver actionDriver;

     public RadioButton (WebDriver driver){
         this.driver = driver;
         this.actionDriver= new ActionDriver(driver);
         PageFactory.initElements(driver,this);

     }
    @FindBy(id = "menuform:j_idt40")
    public WebElement menuItems_ele;

    @FindBy(id = "menuform:m_radio")
    public WebElement radioBtn_ele;

    @FindBy(xpath = "//table[@id='j_idt87:console2']//input[@type='radio']")
    public List<WebElement> selectedradioBtn_ele;

    @FindBy(id="j_idt87:age:0")
    public WebElement ageRadioBtn;

    @FindBy(xpath = "//label[@for='j_idt87:age:0']")
    public WebElement selectAgeBtn;


    public void radiobuttonAction(){
        actionDriver.click(menuItems_ele);
        actionDriver.click(radioBtn_ele);

        //Find the default select radio button

        int index =-1;

        for (WebElement radioElement:selectedradioBtn_ele){
            index++;
            if (radioElement.isSelected()){
                WebElement defaultSelectedElement= driver.findElement(By.xpath("//label[@for='j_idt87:console2:"+index+"']"));
                String selectedRadioBtn =defaultSelectedElement.getText();
                System.out.print("The selected button is: "+selectedRadioBtn);
                break;
            }
        }

        if(!ageRadioBtn.isSelected()){
            actionDriver.click(selectAgeBtn);

        }

//        for(WebElement element:selectedradioBtn_ele){
//            if(element.isSelected()){
//
//                String selectedRadiBtn=element.getAttribute("value");
//                System.out.print("The Selected Button Is: "+selectedRadiBtn);
//                 break;
//            }
//
//        }



     }
}
