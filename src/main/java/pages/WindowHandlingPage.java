package pages;

import actionDriver.ActionDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WindowHandlingPage {
    WebDriver driver;
    private ActionDriver actionDriver;

    public WindowHandlingPage(WebDriver driver){
        this.driver=driver;
        this.actionDriver=new ActionDriver(driver);
        PageFactory.initElements(driver,this);



    }
    @FindBy(id = "menuform:j_idt39")
    public WebElement menuWindow_ele;

    @FindBy(id="//li[@id='menuform:m_window']//a")
    public WebElement windowLink;

    @FindBy(id="j_idt88:new")
    public WebElement firstWindowButton_ele;

    public void windowActions(){

//        actionDriver.click(menuWindow_ele);
//        actionDriver.click(windowLink);

        String oldWindow=driver.getWindowHandle();
        System.out.println("Parent Window: "+ oldWindow);


        actionDriver.click(firstWindowButton_ele);
        Set<String> handles= driver.getWindowHandles();
        System.out.println("handle size "+handles.size());

        for(String newWindow:handles){
            System.out.println(newWindow);
            driver.switchTo().window(newWindow);
            System.out.println("Page title is: "+driver.getTitle());
        }
        driver.close();

        driver.switchTo().window(oldWindow);

        boolean firstButtonVisibility =actionDriver.isDisplayed(firstWindowButton_ele);
        System.out.println("open button visibility: "+firstButtonVisibility);

        //second method using list
        /*List<String> list =new ArrayList<String>(handles); //converting set to list
        if(list.size()>1){
            driver.switchTo().window(list.get(1));
            System.out.println("Child tab title is: "+driver.getTitle());
            driver.close();
            driver.switchTo().window(oldWindow);


        }*/

        //find the number of open tabs
        WebElement multyWindowButtonwin=driver.findElement(By.xpath("//*[@id='j_idt88:j_idt91']"));
        multyWindowButtonwin.click();
        Set<String> multiWindows=driver.getWindowHandles();
        int howManyWindowscn=multiWindows.size();
        System.out.println("Number of open windows: "+howManyWindowscn);

        //close all the windows except primary
        WebElement dontCloseMeButtonwin=driver.findElement(By.xpath("//*[@id='j_idt88:j_idt93']"));
        dontCloseMeButtonwin.click();

        Set<String> newWindowsHandle=driver.getWindowHandles();

        for(String allWindows:newWindowsHandle){
            if(!allWindows.equals(oldWindow)){
                driver.switchTo().window(allWindows);
                driver.close();
            }
        }
        /*driver.switchTo().window(oldWindow);
        driver.close();*/
        driver.quit();




    }
}
