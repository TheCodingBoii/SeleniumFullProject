package base;

import actionDriver.ActionDriver;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;
import utility.ExtentReport.ExtentReportUtility;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class BaseClass {



    private static final Logger logger = LogManager.getLogger(BaseClass.class);
    public static WebDriver driver;
    protected static Properties prop;




    @BeforeSuite
    public void beforeSuite() throws IOException {


        prop = new Properties();
        FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
        prop.load(fis);

        ExtentReportUtility.startReport();

        try {
            String logFilePath = "logs/automation.log";
            File logFile = new File(logFilePath);
            if (logFile.exists()) {
                // Clear the contents of the file (truncate)
                FileUtils.write(logFile, "", false);
                logger.info("Log file cleaned: " + logFilePath);
            } else {
                // Create the log file if it doesn't exist
                FileUtils.touch(logFile);
                logger.info("Log file created hence not exist: " + logFilePath);
            }
        } catch (IOException e) {
            logger.error("Error cleaning or creating the log file: " + e.getMessage());
        }
    }

    @BeforeMethod
    public void openPage(){

        System.out.println("Setting webdriver for: " + this.getClass().getSimpleName());
        launchBrowser();
        configureBrowser();

    }

    public static String getAdminUsername() {
        return prop.getProperty("username");
    }

    public static String getAdminPassword() {
        return prop.getProperty("password");
    }

    private void launchBrowser() {

        String browser = prop.getProperty("browser");

        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else {
            throw new IllegalArgumentException("Browser Not Supported: " + browser);
        }
        logger.info("Testcase Automating with: "+browser);

    }





    private void configureBrowser() {
        int implicitWait = Integer.parseInt(prop.getProperty("implicit_wait"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));

        driver.manage().window().maximize();

        try {
            driver.get(prop.getProperty("App_url"));
        } catch (Exception e) {
            System.out.println("Faild to Navigate to the URL: " + e.getMessage());

        }
    }


    @AfterMethod
    public void closeBrowser(){
        if (driver != null) {
            try {
                driver.quit();
            } catch (Exception e) {
                System.out.println("Unable to quite the browser: " + e.getMessage());
            }
        }
    }

    // Prop getter method
    public static Properties getProp() {
        return prop;
    }
    // Driver getter method
    public WebDriver getDriver() {
        return driver;
    }

    // Driver setter method
    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    // static wait for pause
    public void staticWait(int secounds) {
        LockSupport.parkNanos(TimeUnit.SECONDS.toNanos(secounds));
    }

    @AfterSuite
    public void afterSuite(){

        ExtentReportUtility.endReport();

    }

}
