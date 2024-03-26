package rahulshettyacademy.TestComponents;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestListener;
import org.testng.ITestResult;
import rahulshettyacademy.resources.ExtentReporterNG;

import java.io.IOException;

public class Listeners extends  BaseTest implements ITestListener {
    ExtentReports extent = ExtentReporterNG.getReportObject();
    ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, "Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        //test.log(Status.FAIL, "Test Fail");
        test.fail(result.getThrowable());
        try {
            getScreenshot(result.getMethod().getMethodName());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        test.addScreenCaptureFromPath(null, null);

        //get screenshot and attach to the report

    }
}
