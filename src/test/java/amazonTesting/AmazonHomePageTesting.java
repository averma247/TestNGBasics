package amazonTesting;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.pages.amazon.HomePage;

import reports.Reporter;

public class AmazonHomePageTesting extends TestBase{
	
	HomePage homepage;
	String productsearch=null;
	
	
	@BeforeClass
	public void setup() {
		
		homepage= new HomePage(getDriver(), configProp.getProperty("implicitwait"), configProp.getProperty("explicitwait"));
		
	}
	
	@Test
	public void verifyHomePage() {
		
		productsearch="iPhone 13";
		
		Reporter.reportStep("Searching Product: "+productsearch);
		
		homepage.searchProduct(productsearch);
		//Assert.assertTrue(homepage.checkResultText(productsearch), "Searched text does not matched.");
		Reporter.reportStep("Products searched on Home page");

		
	}

}
