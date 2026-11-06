package testCases;

import base.BaseClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.WindowHandlingPage;

public class TC008_WindowHandle extends BaseClass {
    WindowHandlingPage windowHandlingPage;

    @BeforeMethod
    public void windowHandle(){
        this.windowHandlingPage =new WindowHandlingPage(driver);
        driver.get("https://leafground.com/window.xhtml");
    }

    @Test
    public void windowTest(){

        windowHandlingPage.windowActions();
    }
}
