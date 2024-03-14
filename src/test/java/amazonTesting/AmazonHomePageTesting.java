package amazonTesting;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.pages.amazon.HomePage;

public class AmazonHomePageTesting extends TestBase{
	
	HomePage homepage;
	
	
	@BeforeClass
	public void setup() {
		
		homepage= new HomePage(getDriver(), configProp.getProperty("implicitwait"), configProp.getProperty("explicitwait"));
		
	}
	
	@Test
	public void verifyHomePage() {
		
		homepage.searchProduct("iPhone 11");
		
	}

}
