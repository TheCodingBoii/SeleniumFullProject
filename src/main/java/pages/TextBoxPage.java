package pages;

import actionDriver.ActionDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class TextBoxPage {
    private ActionDriver actionDriver;
    WebDriver driver;

    public TextBoxPage(WebDriver driver){
        this.driver =driver;
        this.actionDriver = new ActionDriver(driver);
        PageFactory.initElements(driver,this);

    }
    @FindBy(id = "menuform:j_idt40")
    public WebElement menuItems_ele;

    @FindBy(id = "menuform:m_input")
    public WebElement textBoxLink_ele;

    @FindBy(xpath = "//*[@id='j_idt88:name']")
    public WebElement typeTextBox_ele;

    @FindBy(xpath = "//*[@id='j_idt88:j_idt91']")
    public WebElement appendTextBox_ele;

    @FindBy(id = "j_idt88:j_idt93")
    public WebElement tbEnabled_ele;

    @FindBy(xpath = "//*[@id='j_idt88:j_idt95']")
    public WebElement clearText_ele;

    @FindBy(xpath = "//*[@id='j_idt88:j_idt97']")
    public WebElement retrieveText_ele;

    @FindBy(xpath = "//*[@id='j_idt88:j_idt99']")
    public WebElement typeEmail_ele;

    @FindBy(xpath = "//*[@id='j_idt88:j_idt101']")
    public WebElement secondElement_ele;



    public void TextBox(){
        actionDriver.click(menuItems_ele);

        actionDriver.click(textBoxLink_ele);

        actionDriver.enterText(typeTextBox_ele,"Shan");

        actionDriver.enterText(appendTextBox_ele,"Colombo");

        boolean verifyTB =tbEnabled_ele.isEnabled();
        System.out.println("This TextBox Is: "+verifyTB);

        actionDriver.clearText(clearText_ele);

        String theText= retrieveText_ele.getAttribute("value");
        System.out.println("This Text Is: "+theText);

        actionDriver.enterText(typeEmail_ele,"testemail123@gmail.com" + Keys.TAB);
        WebElement activeElement =driver.switchTo().activeElement();
        Assert.assertEquals(activeElement,secondElement_ele,"Focus did not move to the next element after TAB key");












    }
}
