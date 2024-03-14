package amazonTesting;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import reports.ExtentManager;
import reports.Reporter;

public class TestBase {
	
	public static final Properties configProp = new Properties();

	
	private static WebDriver driver;
	public static WebDriverWait wait;
	
	
	@BeforeSuite
	public void init() throws IOException {
		
		configProp.load(TestBase.class.getClassLoader().getResourceAsStream("config.properties"));
		
	}
	
	
	@BeforeMethod
	public void beforeMethodSetup(Method m){

		Reporter.startTestCase(m.getName());

	}
	
	
	@BeforeTest
	public void openApplication() {	
		//if chrome is selected.
		setupChrome();	
		driver.manage().timeouts().implicitlyWait(Long.parseLong(configProp.getProperty("implicitwait")), TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().setScriptTimeout(120, TimeUnit.SECONDS);
		driver.get(configProp.getProperty("url"));
		wait = new WebDriverWait(driver, Long.parseLong(configProp.getProperty("implicitwait")));
		

	}
	
	
	private void setupChrome() {
		System.setProperty("webdriver.chrome.silentOutput", "true");
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-web-security");
		options.addArguments("--allow-running-insecure-content");
		options.addArguments("--autoplay-policy=no-user-gesture-required");
		//options.addArguments("--user-data-dir="+configProp.getProperty("browserProfile"));
		//options.addArguments("--no-startup-window");
		options.addArguments("--disable-session-crashed-bubble");
		options.addArguments("--disable-extensions");
		options.addArguments("--disable-application-cache");
		/*try {
			Files.deleteIfExists(Paths.get(configProp.getProperty("browserProfile")).resolve("Default").resolve("Preferences"));
		} catch (IOException ioException) {

		}*/
		driver = new ChromeDriver(options);
	}
	
	@AfterMethod
	public void cleanup(ITestResult result) {
		if (result.getThrowable() != null)
			Reporter.reportStep("Failure cause " + result.getThrowable().getMessage(), result.getStatus());
		Reporter.reportStep("Test Complete", result.getStatus());
		ExtentManager.getInstance().flush();
	}
	
	
	
	@AfterTest
	public void tearDown() {
		driver.close();
		driver.quit();
	}
	
	public WebDriver getDriver(){
		return driver;
	}

}
