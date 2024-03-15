package reports;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;

public class Reporter {
	
	public static final String LINE_BREAK_HTML = "<br/>";
    private static final Logger logger = LogManager.getLogger(Reporter.class);

    public static synchronized ExtentTest startTestCase(String testName) {
        logger.info(String.format("TestCase:- %s Started", testName));
        return ExtentTestManager.createTest(testName);
    }

    public static synchronized void reportStep(String desc, int status) {
        switch (status) {
            case ITestResult.SUCCESS:
                ExtentTestManager.getTest().pass(desc);
                logger.info(String.format("%s:- Step Passed ", desc));
                break;
            case ITestResult.FAILURE:
                ExtentTestManager.getTest().fail(desc);
                logger.error(desc);
                break;
            case ITestResult.SKIP:
                ExtentTestManager.getTest().skip(desc);
                logger.info(String.format("%s:- Step skipped ", desc));
                break;
            default:
                ExtentTestManager.getTest().info(desc);
                logger.info(desc);
        }
    }

    public static synchronized void reportStep(String desc) {
        logger.info(desc);
        ExtentTestManager.getTest().info(desc);
    }
    
    public static synchronized void reportStepWithScreenShot(String path) throws IOException {
    	logger.info("Path of screenshot "+path);
    	ExtentTestManager.getTest().addScreenCaptureFromPath(path);
    	
    }

}
