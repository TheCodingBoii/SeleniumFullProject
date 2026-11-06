package pages;

import actionDriver.ActionDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FramePage {
    WebDriver driver;
    private  ActionDriver actionDriver;

    public FramePage(WebDriver driver){
        this.driver=driver;
        this.actionDriver= new ActionDriver(driver);
        PageFactory.initElements(driver,this);

    }
    @FindBy(id = "menuform:j_idt38")
    public WebElement menuWindow_ele;

    @FindBy(xpath = "//li[@id='menuform:m_frame']//a")
    public WebElement frameLink_ele;

    @FindBy(xpath = "//button[@id='Click']")
    public WebElement firstFrameBtn_ele;

    @FindBy(id = "Click")
    public WebElement nestedframeBtn;

    @FindBy(tagName = "iframe")
    public List<WebElement> countOfFrame;

    public void frameAction(){


        actionDriver.click(menuWindow_ele);
        actionDriver.click(frameLink_ele);

        driver.switchTo().frame(0);
        actionDriver.click(firstFrameBtn_ele);
        String afterClickBtnText =frameLink_ele.getText();
        System.out.println(afterClickBtnText);

        //nested Frame

        driver.switchTo().defaultContent();
        driver.switchTo().frame(2); //inside the third frame
        driver.switchTo().frame("frame2");
        actionDriver.click(nestedframeBtn);

        String nestedClickBtnText =nestedframeBtn.getText();
        System.out.println(nestedClickBtnText);

        //count the all frames

        driver.switchTo().defaultContent();
        int countFarme= countOfFrame.size();
        System.out.println(countFarme);


    }
}
