package pages;

import actionDriver.ActionDriver;
import com.beust.ah.A;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertPage {

    WebDriver driver;
    private ActionDriver actionDriver;

    public AlertPage(WebDriver driver){
        this.driver=driver;
        this.actionDriver =new ActionDriver(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//form[@id='menuform']//li[@id='menuform:j_idt38']")
    public WebElement menuItems_ele;

    @FindBy(id="menuform:m_overlay")
    public WebElement alertLink;

    @FindBy(id="j_idt88:j_idt91")
    public WebElement firstAlertBox;

    @FindBy(id = "j_idt88:j_idt93")
    public WebElement secondAlertBox;

    @FindBy(id = "j_idt88:j_idt104")
    public WebElement thirdAlertBox;

    public void alertAction(){
//        menuItems_ele.click();
//        alertLink.click();
//        actionDriver.click(menuItems_ele);
//        actionDriver.click(alertLink);
//
        actionDriver.click(firstAlertBox);

        //use alert class (CONFIRM THE ALERT BOX)
        actionDriver.acceptAlert();


        actionDriver.click(secondAlertBox);
        actionDriver.dismissAlert();

        actionDriver.click(thirdAlertBox);
        String slerttext =actionDriver.getAlertText();

        System.out.print(slerttext);
        driver.switchTo().alert().sendKeys("My name is Shan");
        actionDriver.acceptAlert();




    }
}
