package pages;

import actionDriver.ActionDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utility.ExtentReport.ExtentReportUtility;

import java.util.List;

public class LinkPage {
    private ActionDriver actionDriver;
    WebDriver driver;

    public LinkPage(WebDriver driver){
        this.actionDriver=new ActionDriver(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    @FindBy(id = "menuform:j_idt40")
    public WebElement menuItems;

    @FindBy(xpath = "//*[@id='menuform:m_link']/a")
    public WebElement linkMenu;

    @FindBy(linkText = "Go to Dashboard")
    public WebElement linkOfDashboard;

    @FindBy(partialLinkText = "Find the URL")
    public WebElement destinationUrl;

    @FindBy(linkText = "Broken?")
    public WebElement brokenLink;

    @FindBy(tagName = "a")
    public List<WebElement> linkCount;

    @FindBy(className = "layout-main-content")
    public WebElement layoutElement;

    @FindBy(linkText = "Go to Dashboard")
    public WebElement linkOfDashboard2;

    public void linkActions(){
        actionDriver.click(menuItems);
        actionDriver.click(linkMenu);
        String actualUrl = driver.getCurrentUrl();

        Assert.assertTrue(
                actualUrl.contains("https://leafground.com/link.xhtml"),
                "Navigation to the Links page failed. Actual URL: " + actualUrl);

        actionDriver.click(linkOfDashboard);

        driver.navigate().back();

        String destination =destinationUrl.getAttribute("href");
        System.out.println("This Link is goes to: "+destination);

        actionDriver.click(brokenLink);
        String title =driver.getTitle();
        if(title.contains("404")){
            System.out.println("This Link is broken");
        }else{
            System.out.println("Not broken");
        }

        driver.navigate().back();

        actionDriver.click(linkOfDashboard2);

        driver.navigate().back();

        int count=linkCount.size();
        System.out.println("Count of full page links: "+count);

        ExtentReportUtility.captureScreenshotAsBase64_ReportOnly_StepInfo(driver,"Links");


        List<WebElement> tagCount=layoutElement.findElements(By.tagName("a"));
        int sectionLinkCount=tagCount.size();
        System.out.println("Count of layout links: "+sectionLinkCount);





    }

//    public void confirmNavigation(){
//        // Verify navigation
//
//
//    }



}
