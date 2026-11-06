package pages;

import actionDriver.ActionDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Tablepage {
    WebDriver driver;
    private ActionDriver actionDriver;

    public Tablepage(WebDriver driver){
        this.driver= driver;
        this.actionDriver=new ActionDriver(driver);
        PageFactory.initElements(driver,this);
    }

    public void TableAction(){
        
    }
}
