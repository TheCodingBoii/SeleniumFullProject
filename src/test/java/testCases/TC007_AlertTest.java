package testCases;

import base.BaseClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AlertPage;

public class TC007_AlertTest extends BaseClass {
    private AlertPage alertPage;

    @BeforeMethod
    public void alertHandle(){
        this.alertPage = new AlertPage(driver);
        driver.get("https://leafground.com/alert.xhtml");
    }

    @Test
    public void alertTest(){
        alertPage.  alertAction();

    }
}
