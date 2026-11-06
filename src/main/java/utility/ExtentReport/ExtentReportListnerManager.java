package utility.ExtentReport;

import base.BaseClass;
import org.testng.IAnnotationTransformer;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ExtentReportListnerManager extends BaseClass implements ITestListener, IAnnotationTransformer {



    @Override
    public void onTestStart(ITestResult result) {
        String testName = result.getTestClass().getName() + " - " + result.getMethod().getMethodName();
        ExtentReportUtility.createTest(testName);
        ExtentReportUtility.test.info("Started Test Execution :" + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentReportUtility.test.assignCategory(result.getMethod().getGroups());  //To display Groups in the Report
        ExtentReportUtility.test.pass(" Test Case Passed : " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentReportUtility.test.assignCategory(result.getMethod().getGroups());  //To display Groups in the Report
        ExtentReportUtility.test.fail(result.getName() + " - Test Case Failed");
        ExtentReportUtility.test.fail(result.getThrowable());
        ExtentReportUtility.captureScreenshotAsBase64_ReportOnly_FailCase(getDriver(),result.getName()+"_failed_Point_Screenshot");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentReportUtility.test.assignCategory(result.getMethod().getGroups());  //To display Groups in the Report
        ExtentReportUtility.test.skip(result.getName() + " - Test Case skipped");
        ExtentReportUtility.captureScreenshotAsBase64_ReportOnly_SkipCase(getDriver(),result.getName()+"_skipped_Point_Screenshot");
    }
}
