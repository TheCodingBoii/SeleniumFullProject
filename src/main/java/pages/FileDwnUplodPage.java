package pages;

import actionDriver.ActionDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.io.File;

public class FileDwnUplodPage {

    WebDriver driver;
    private ActionDriver actionDriver;

    public FileDwnUplodPage(WebDriver driver){
        this.driver=driver;
        this.actionDriver = new ActionDriver(driver);
        PageFactory.initElements(driver,this);

    }

    public void dwnUploadAction(){

        driver.get("https://leafground.com/file.xhtml");
        WebElement downloadBtn= driver.findElement(By.id("j_idt93:j_idt95"));
        downloadBtn.click();

        File file= new File("C:\\Users\\Admin\\Downloads");
        File[] totalFiles= file.listFiles();

        for(File findFile:totalFiles) {
            if (findFile.getName().equals("TestLeaf Logo.png")) {
                System.out.println("File is downloaded");
                break;





            }
        }



        driver.get("https://leafground.com/file.xhtml");

//        WebElement uploadBtn= driver.findElement(By.id("j_idt88:j_idt89"));
//        uploadBtn.click();
//
//        //windows control begin here
//        String data="C:\\Users\\Admin\\Downloads\\TestLeaf Logo.png";
//        StringSelection selection = new StringSelection(data);
//
//        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection,null);
//
//        Thread.sleep(3000);
//        Robot robot = new Robot();
//        robot.keyPress(KeyEvent.VK_CONTROL);
//        robot.keyPress(KeyEvent.VK_V);
//        robot.keyRelease(KeyEvent.VK_V);
//        robot.keyRelease(KeyEvent.VK_CONTROL);
//
//        robot.keyPress(KeyEvent.VK_ENTER);
//        robot.keyRelease(KeyEvent.VK_ENTER);

        //Using send keys (Applicable only element type is file)
        String data="C:\\Users\\Admin\\Downloads\\TestLeaf Logo.png";
        WebElement uploadUsingSendKeys= driver.findElement(By.id("j_idt88:j_idt89_input"));
        uploadUsingSendKeys.sendKeys(data);
    }
}
