package amazonTesting;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.pages.amazon.HomePage;

import reports.Reporter;

public class    AmazonHomePageTesting extends  TestBase{
	
	HomePage homepage;
	String productsearch=null;
	
	
	@BeforeClass
	public void setup() {
		
		homepage= new HomePage(getDriver(), configProp.getProperty("implicitwait"), configProp.getProperty("explicitwait"));
		
	}
	
	@Test(enabled = false)
	public void verifyHomePage() {
		
		productsearch="iPhone 15";
		
		Reporter.reportStep("Searching Product: "+productsearch);
		
		homepage.searchProduct(productsearch);
		Assert.assertTrue(homepage.checkResultText(productsearch), "Searched text does not matched.");
		Reporter.reportStep("Products searched on Home page");

		
	}
	@Test(enabled = true,priority = 0)
	public  void verifyItemAddedToCart(){
		productsearch="Samsung Galaxy S24 Ultra 5G";

		Reporter.reportStep("Searching Product: "+productsearch);

		homepage.searchProduct(productsearch);
		Assert.assertTrue(homepage.checkResultText(productsearch), "Searched text does not matched.");
		Reporter.reportStep("Products searched on Home page");

	}

	@Test(enabled = false,priority = 0)

	public void verifyItemDeletedFromCart(){

	}

}
