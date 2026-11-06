package pages;

import actionDriver.ActionDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MouseActionPage {
    WebDriver driver;
    private ActionDriver actionDriver;

    public MouseActionPage(WebDriver driver){

        this.driver=driver;
        this.actionDriver= new ActionDriver(driver);
        PageFactory.initElements(driver,this);



    }

    @FindBy(id = "menuform:j_idt38")
    public WebElement menuWindow_ele;

    @FindBy(xpath = "//li[@id='menuform:m_drag']//a")
    public WebElement mouseAction_ele;

    @FindBy(id = "form:drag_content")
    public WebElement from_ele;

    @FindBy(id = "form:drop")
    public WebElement to_ele;

    @FindBy(id = "//*[@id='form:j_idt125']/span[1]")
    public WebElement slideBar_ele;



    public void MouseAction(){

        actionDriver.click(menuWindow_ele);
        actionDriver.click(mouseAction_ele);

        Actions action =new Actions(driver);
        action.moveToElement(driver.findElement(By.id("menuform:j_idt37"))).perform();

//        action.clickAndHold(from_ele).moveToElement(to_ele).release(to_ele).perform(); //
        action.dragAndDrop(from_ele,to_ele).perform();

        action.dragAndDropBy(slideBar_ele,50,0).perform();

        System.out.println("Location: "+slideBar_ele.getLocation());

        //Right click
//        action.contextClick((rightClickButton)).perform();
    }
}
