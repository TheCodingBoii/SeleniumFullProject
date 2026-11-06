package testCases;

import base.BaseClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LinkPage;
import utility.ExtentReport.ExtentReportListnerManager;



public class TC001_Links extends BaseClass {
    private LinkPage linkpage;

    private static final Logger logger = LogManager.getLogger(TC001_Links.class);

    @BeforeMethod
    public void TC001_Links(){
         this.linkpage = new LinkPage(driver);

    }
    @Test
    public void linkTest(){

        logger.debug("debug TC001_Links");
        logger.info("***Starting TC001_Links***");

        logger.info("Verifying Link page is working as expected");
        linkpage.linkActions();

    }
}
