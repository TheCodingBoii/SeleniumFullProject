package actionDriver;

import base.BaseClass;

import org.openqa.selenium.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class ActionDriver {

    private WebDriver driver;
    private WebDriverWait wait;



    public ActionDriver(WebDriver driver) {
        this.driver = driver;
        int explicitWait = Integer.parseInt(BaseClass.getProp().getProperty("explicit_wait"));
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(explicitWait));
    }

    // Method to click an element
    public void click(WebElement element) {
        try {
            applyBorder(element,"green");
            waitForElementToBeClickable(element);
            element.click();
        } catch (Exception e) {
            applyBorder(element,"red");

        }
    }
    //keyborad action(press enter)
    public void pressEnter(WebElement element) {
        element.sendKeys(Keys.ENTER);
    }

    // Method to enter text into an input field --Avoid Code Duplication - fix the
    // multiple calling method
    public void enterText(WebElement element, String value) {
        try {
            waitForElementToBeVisible(element);
            applyBorder(element,"green");
            element.clear();
            element.sendKeys(value);
        } catch (Exception e) {

        }
    }

    // Method to get text from an input field
    public String getText(WebElement element) {
        try {
            waitForElementToBeVisible(element);
            applyBorder(element,"green");
            return element.getText();
        } catch (Exception e) {
            applyBorder(element,"red");

            return "";
        }
    }

    // Method to compare Two text -- changed the return type
    public boolean compareText(WebElement element, String expectedText) {
        try {
            waitForElementToBeVisible(element);
            String actualText = element.getText();
            if (expectedText.equals(actualText)) {
                applyBorder(element,"green");

                return true;
            } else {
                applyBorder(element,"red");

                return false;
            }
        } catch (Exception e) {
            applyBorder(element,"red");

        }
        return false;
    }

    // Simplified the method and remove redundant conditions
    public boolean isDisplayed(WebElement element) {
        try {
            waitForElementToBeVisible(element);
            applyBorder(element,"green");
            return element.isDisplayed();
        } catch (Exception e) {
            applyBorder(element,"red");

            return false;
        }
    }

    // Wait for the page to load
    public void waitForPageLoad(int timeOutInSec) {
        try {
            wait.withTimeout(Duration.ofSeconds(timeOutInSec)).until(WebDriver -> ((JavascriptExecutor) WebDriver)
                    .executeScript("return document.readyState").equals("complete"));

        } catch (Exception e) {

        }
    }

    // Scroll to an element -- Added a semicolon ; at the end of the script string
    public void scrollToElement(WebElement element) {
        try {
            applyBorder(element,"green");
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", element);
        } catch (Exception e) {
            applyBorder(element,"red");

        }
    }

    // Wait for Element to be clickable
    private void waitForElementToBeClickable(WebElement element) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {

        }
    }

    // Wait for Element to be Visible
    private void waitForElementToBeVisible(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {

        }
    }

    // Utility method to check if a string is not null or empty
    private boolean isNotEmpty(String value) {
        return value != null && !value.isEmpty();
    }

    // Utility method to truncate long strings
    private String truncate(String value, int maxLength) {
        if (value == null || value.length() <= maxLength) {
            return value;
        }
        return value.substring(0, maxLength) + "...";
    }

    //Utility Method to Border an element
    public void applyBorder(WebElement element,String color) {
        try {
            //Apply the border
            String script = "arguments[0].style.border='3px solid "+color+"'";
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript(script, element);
        } catch (Exception e) {
            throw e;
        }
    }

    // ===================== Select Methods =====================

    // Method to select a dropdown by visible text
    public void selectByVisibleText(WebElement element, String value) {
        try {
            new Select(element).selectByVisibleText(value);
            applyBorder(element, "green");

        } catch (Exception e) {
            applyBorder(element, "red");

        }
    }

    // Method to select a dropdown by value
    public void selectByValue(WebElement element, String value) {
        try {
            new Select(element).selectByValue(value);
            applyBorder(element, "green");

        } catch (Exception e) {
            applyBorder(element, "red");

        }
    }

    // Method to select a dropdown by index
    public void selectByIndex(WebElement element, int index) {
        try {
            new Select(element).selectByIndex(index);
            applyBorder(element, "green");

        } catch (Exception e) {
            applyBorder(element, "red");

        }
    }

    // Method to get all options from a dropdown
    public List<String> getDropdownOptions(WebElement dropdownElement) {
        List<String> optionsList = new ArrayList<>();
        try {
            Select select = new Select(dropdownElement);
            for (WebElement option : select.getOptions()) {
                optionsList.add(option.getText());
            }
            applyBorder(dropdownElement, "green");
        } catch (Exception e) {
            applyBorder(dropdownElement, "red");

        }
        return optionsList;
    }


    // ===================== JavaScript Utility Methods =====================

    // Method to click using JavaScript
    public void clickUsingJS(WebElement element) {
        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
            applyBorder(element, "green");
        } catch (Exception e) {
            applyBorder(element, "red");

        }
    }

    // Method to scroll to the bottom of the page
    public void scrollToBottom() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");

    }

    // Method to highlight an element using JavaScript
    public void highlightElementJS(WebElement element) {
        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid yellow'", element);
        } catch (Exception e) {

        }
    }

    // ===================== Window and Frame Handling =====================

    public void closeCurrentBrowserTabAndSwitchToNewTab() {
        List<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        if (tabs.size() > 1) {
            driver.switchTo().window(tabs.get(0));
            driver.close();
            driver.switchTo().window(tabs.get(1));
        }
    }

    public void closeCurrentBrowserTabAndSwitchToOldTab() {
        List<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        if (tabs.size() > 1) {
            driver.close();
            driver.switchTo().window(tabs.get(0));
        }
    }

    public void closeAllWindowsExceptPrimary(String oldWindowReference) {
        Set<String> newWindowsHandles=driver.getWindowHandles();
        for (String allwindows : newWindowsHandles) {
            if (!allwindows.equals(oldWindowReference)){
                driver.switchTo().window(allwindows);
                driver.close();
            }
        }
        driver.switchTo().window(oldWindowReference);
    }


    // Method to switch between browser windows
    public void switchToWindow(String windowTitle) {
        try {
            Set<String> windows = driver.getWindowHandles();
            for (String window : windows) {
                driver.switchTo().window(window);
                if (driver.getTitle().equals(windowTitle)) {

                    return;
                }
            }

        } catch (Exception e) {

        }
    }

    // Method to switch to an iframe
    public void switchToFrameByElement(WebElement element) {
        try {
            driver.switchTo().frame(element);
        } catch (Exception e) {

        }
    }

    public boolean switchToFrameByIndex(int index) {
        boolean flag = false;
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe")));
            driver.switchTo().frame(index);
            flag = true;
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            if (flag) {
                System.out.println("Frame with index \"" + index + "\" is selected");
            } else {
                System.out.println("Frame with index \"" + index + "\" is not selected");
            }
        }
    }

    public boolean switchToFrameById(String idValue) {
        boolean flag = false;
        try {
            driver.switchTo().frame(idValue);
            flag = true;
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (flag) {
                System.out.println("Frame with Id \"" + idValue + "\" is selected");
            } else {
                System.out.println("Frame with Id \"" + idValue + "\" is not selected");
            }
        }
    }

    public boolean switchToFrameByName(String nameValue) {
        boolean flag = false;
        try {
            driver.switchTo().frame(nameValue);
            flag = true;
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            if (flag) {
                System.out.println("Frame with Name \"" + nameValue + "\" is selected");
            } else if (!flag) {
                System.out.println("Frame with Name \"" + nameValue + "\" is not selected");
            }
        }
    }

    // Method to switch back to the default content
    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();

    }

    // ===================== Alert Handling =====================

    // Method to accept an alert popup
    public void acceptAlert() {
        try {
            driver.switchTo().alert().accept();

        } catch (Exception e) {

        }
    }

    // Method to dismiss an alert popup
    public void dismissAlert() {
        try {
            driver.switchTo().alert().dismiss();

        } catch (Exception e) {

        }
    }

    // Method to get alert text
    public String getAlertText() {
        try {
            return driver.switchTo().alert().getText();
        } catch (Exception e) {

            return "";
        }
    }

    // ===================== Browser Actions =====================

    public void refreshPage() {
        try {
            driver.navigate().refresh();

        } catch (Exception e) {

        }
    }

    public String getCurrentURL() {
        try {
            String url = driver.getCurrentUrl();

            return url;
        } catch (Exception e) {

            return null;
        }
    }

    public void maximizeWindow() {
        try {
            driver.manage().window().maximize();

        } catch (Exception e) {

        }
    }

    public void maximizeWindowtoWantedSize(int width, int height) {
        try {
            Dimension dimension = new Dimension(width,height);
            driver.manage().window().setSize(dimension);

        } catch (Exception e) {

        }
    }


    // ===================== Advanced WebElement Actions =====================

    public void moveToElement(WebElement element) {
        try {
            Actions actions = new Actions(driver);
            actions.moveToElement(element).perform();
        } catch (Exception e) {

        }
    }

    public void dragAndDrop(WebElement source, WebElement target) {
        try {
            Actions actions = new Actions(driver);
            actions.dragAndDrop(source, target).perform();
        } catch (Exception e) {

        }
    }

    public void doubleClick(WebElement element) {
        try {
            Actions actions = new Actions(driver);
            actions.doubleClick(element).perform();
        } catch (Exception e) {

        }
    }

    public void rightClick(WebElement element) {
        try {
            Actions actions = new Actions(driver);
            actions.contextClick(element).perform();
        } catch (Exception e) {

        }
    }

    public void sendKeysWithActions(WebElement element, String value) {
        try {
            Actions actions = new Actions(driver);
            actions.sendKeys(element, value).perform();
        } catch (Exception e) {

        }
    }

    public void actionsClick(WebElement ele) {

        Actions act = new Actions(driver);
        act.moveToElement(ele).click().build().perform();
    }

    public void clearText(WebElement element) {
        try {
            element.clear();
        } catch (Exception e) {

        }
    }

    // Method to upload a file
    public void uploadFile(WebElement element, String filePath) {
        try {
            element.sendKeys(filePath);
            applyBorder(element, "green");

        } catch (Exception e) {
            applyBorder(element, "red");

        }
    }

    // Method to upload a file - windows dialog box
    public void uploadFileInToWindowsBasedDialogBox(String filePath) throws InterruptedException, AWTException {
        StringSelection selection = new StringSelection(filePath);
        //Coping the path to clipboard
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection,null);

        Thread.sleep(4000);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        Thread.sleep(3000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    //Get current date
    public String getCurrentTime() {
        String currentDate = new SimpleDateFormat("yyyy-MM-dd-hhmmss").format(new Date());
        return currentDate;
    }

}
