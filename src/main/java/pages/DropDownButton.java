package pages;

import actionDriver.ActionDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropDownButton {
    WebDriver driver;
    private ActionDriver actionDriver;


    public  DropDownButton(WebDriver driver){
        this.driver=driver;
        this.actionDriver=new ActionDriver(driver);
        PageFactory.initElements(driver,this);

    }
    @FindBy(id = "menuform:j_idt40")
    public WebElement menuItems_ele;

    @FindBy(id = "menuform:m_dropdown")
    public WebElement dropdownLink_ele;

    @FindBy(className = "ui-selectonemenu")
    public WebElement selectOptions_ele;

    @FindBy(xpath = "//div[@id='j_idt87:country']")
    public WebElement boostrapDropdown_ele;

    @FindBy(xpath = "//ul[@id='j_idt87:country_items']/li")
    public WebElement boostrapOptions_ele;




    public void dropdownActions(){
        actionDriver.click(menuItems_ele);
        actionDriver.click(dropdownLink_ele);
        actionDriver.click(selectOptions_ele);
        actionDriver.selectByVisibleText(selectOptions_ele,"Selenium");

        Select select = new Select(selectOptions_ele);
        List<WebElement> listOption = select.getOptions();
        int optionSize =listOption.size();
        System.out.println("Option Size "+optionSize);

        selectOptions_ele.sendKeys("Playwright");

        actionDriver.click(boostrapDropdown_ele);

        List<WebElement> listOfOptions= driver.findElements(By.xpath("//ul[@id='j_idt87:country_items']/li"));

        for(WebElement element:listOfOptions){
            String dropdownOptions =element.getText();
            if(dropdownOptions.equals("USA")){
                element.click();
                break;
            }
        }

    }


}
