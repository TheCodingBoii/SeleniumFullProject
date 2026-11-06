package pages;

import actionDriver.ActionDriver;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ButtonPage {

    private ActionDriver actionDriver;
    WebDriver driver;

    public ButtonPage(WebDriver driver){
        this.driver=driver;
        this.actionDriver= new ActionDriver(driver);
        PageFactory.initElements(driver,this);


    }

    @FindBy(id = "menuform:j_idt40")
    public WebElement menuItems_ele;

    @FindBy (id = "menuform:m_button")
    public WebElement menuBtnLink_ele;

    @FindBy(id="j_idt88:j_idt90")
    public WebElement cnfrmBtn_ele;

    @FindBy(id="j_idt88:j_idt94")
    public WebElement positionBtn_ele;

    public void buttonActions(){
        actionDriver.click(menuItems_ele);
        actionDriver.click(menuBtnLink_ele);
        actionDriver.click(cnfrmBtn_ele);

        String expectedTitle ="Dashboard";
        String actualTitle=driver.getTitle();

        if(expectedTitle.equals(actualTitle)){
            System.out.println("Actual title is same as expected");
        }else{
            System.out.println("Actual title is not same as expected");
        }

//        Assert.assertEquals(actualTitle,expectedTitle,"Title Mismatch");

        driver.navigate().back();

        Point xyPoint=positionBtn_ele.getLocation();
        int yPsition =xyPoint.getY();
        int xPostion =xyPoint.getX();
        System.out.println("The X position is: "+xPostion+" AND Position of the Y is: "+yPsition);




    }

}
