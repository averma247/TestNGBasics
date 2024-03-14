package amazonTesting;

import org.testng.annotations.Test;

public class AmazonHomePageTesting extends TestBase{
	
	@Test
	public void verifyHomePage() {
		
		System.out.println("Launching and checking Amazon Home Page");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
