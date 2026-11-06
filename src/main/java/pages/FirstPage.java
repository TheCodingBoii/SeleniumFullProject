package pages;

import actionDriver.ActionDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FirstPage {

    private ActionDriver actionDriver;
    WebDriver driver;

    public FirstPage(WebDriver driver){
        this.actionDriver=new ActionDriver(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(className = "gLFyf")
    public WebElement searchBar;

    public void googleSearch(String city){
        actionDriver.enterText(searchBar,city);
        actionDriver.pressEnter(searchBar);

    }



}
