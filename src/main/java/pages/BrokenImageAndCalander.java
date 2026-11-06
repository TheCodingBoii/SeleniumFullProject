package pages;

import actionDriver.ActionDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BrokenImageAndCalander {

    WebDriver driver;
    private ActionDriver actionDriver;

    public BrokenImageAndCalander(WebDriver driver){
        this.driver=driver;
        this.actionDriver=new ActionDriver(driver);
        PageFactory.initElements(driver,this);

    }

    public void findBrokenImageTest(){


        List<WebElement> images= driver.findElements(By.xpath("//div[@class='example']/img"));
        int i=1;
        for(WebElement image:images){
            if(image.getAttribute("naturalWidth").equals("0")){
                System.out.println("Image " +i+ " is broken");
            }else {
                System.out.println("Image " +i+ " is not broken");
            }
            i++;
        }
    }

    public void findBrokenImageTestTwo(){

        WebElement brokenImage =driver.findElement(By.xpath(""));
        if(brokenImage.getAttribute("naturalWidth").equals("0")){
            System.out.println("Image is broken");
        }else {
            System.out.println("Image is not broken");
        }
    }


    public void calenderTests(){


        //1st method
//        driver.switchTo().frame(driver.findElement(By.xpath("//frame[@class='demo-frame']")));
//
//        WebElement datePicker= driver.findElement(By.xpath("//input[@id='datepicker']"));
//        datePicker.sendKeys("07/02/2024");

        //2nd method
        driver.switchTo().frame(driver.findElement(By.xpath("//frame[@class='demo-frame']")));
        WebElement datePicker= driver.findElement(By.xpath("//input[@id='datepicker']"));
        datePicker.click();

        selectFutureDate("2024","October","3");
        selectPastDate("2023","January","5");



    }

    public void selectFutureDate(String year,String month,String date){
        while (true){
            String actualMonth= driver.findElement(By.xpath("//div[@class='example']/img")).getText();
            String actualYear= driver.findElement(By.xpath("//div[@class='example']/img")).getText();
            if (actualYear.equals(year) && actualMonth.equals(month)){
                break;
            }
            else {
                driver.findElement(By.xpath("//div[@class='example']/img")).click();
            }
        }
        List<WebElement> allDates= driver.findElements(By.xpath("//div[@class='example']/img"));

        for(WebElement dateElement:allDates){
            if(dateElement.getText().equals(date)){
                dateElement.click();
                break;
            }
        }
    }

    public void selectPastDate(String year,String month,String date) {
        while (true) {
            String actualMonth = driver.findElement(By.xpath("//div[@class='example']/img")).getText();
            String actualYear = driver.findElement(By.xpath("//div[@class='example']/img")).getText();
            if (actualYear.equals(year) && actualMonth.equals(month)) {
                break;
            } else {
                driver.findElement(By.xpath("//div[@class='example']/img")).click();
            }
        }
        List<WebElement> allDates = driver.findElements(By.xpath("//div[@class='example']/img"));

        for (WebElement dateElement : allDates) {
            if (dateElement.getText().equals(date)) {
                dateElement.click();
                break;
            }
        }

    }
}
