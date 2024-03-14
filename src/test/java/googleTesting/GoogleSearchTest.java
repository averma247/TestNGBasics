package googleTesting;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.SearchPage;

public class GoogleSearchTest extends TestBase{
	
	SearchPage searchpage;
	
	@BeforeClass
	public void setup() {
		
		searchpage= new SearchPage(getDriver(),configProp.getProperty("implicitwait"), configProp.getProperty("explicitwait"));
	}
	
	@Test
	public void verifySearch() {
		System.out.println("Inside Test method");
		searchpage.searchText("selenium automation");
	}

}
