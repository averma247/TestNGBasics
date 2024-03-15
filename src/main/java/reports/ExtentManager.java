package reports;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	
	public static final String REPORT_BASE_FOLDER = "Report";
    public static final String EXTENT_REPORT_FOLDER = "Extent";
    public static final String ARCHIVE_FOLDER_NAME = "Archive";
    public static final String ARCHIVE_EXTENSION = ".zip";
    private static final String EXTENT_REPORT_FILE = "Report.html";
    private static final String EXTENT_REPORT_TITLE = "Extent Report";
    private static final Logger logger = LogManager.getLogger(ExtentManager.class);
    private static ExtentReports extent;

    private ExtentManager() {
    }

    public static synchronized ExtentReports getInstance() {
        if (extent == null) {
            createInstance(Paths.get(REPORT_BASE_FOLDER).resolve(EXTENT_REPORT_FOLDER).resolve(EXTENT_REPORT_FILE).toString());
        }
        return extent;
    }

    protected static synchronized ExtentReports createInstance(String fileName) {
        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(fileName);
        extentSparkReporter.config().setTheme(Theme.STANDARD);
        extentSparkReporter.config().setDocumentTitle(EXTENT_REPORT_TITLE);
        extentSparkReporter.config().setReportName(EXTENT_REPORT_TITLE);
        extent = new ExtentReports();
        extent.setAnalysisStrategy(AnalysisStrategy.CLASS);
        extent.setSystemInfo("User Name", System.getProperty("user.name"));
        extent.setSystemInfo("OS", System.getProperty("os.name"));
        extent.setSystemInfo("Java Version", System.getProperty("java.version")); 
        extent.attachReporter(extentSparkReporter);
        
        return extent;
    }

  
}
