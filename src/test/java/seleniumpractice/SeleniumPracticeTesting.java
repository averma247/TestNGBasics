package seleniumpractice;

import com.pages.demoqa.HomePage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import reports.Reporter;

public class SeleniumPracticeTesting extends TestBase{

    HomePage homepage;
    @BeforeClass
    public void setup() {

        homepage= new HomePage(getDriver(), configProp.getProperty("implicitwait"), configProp.getProperty("explicitwait"));

    }

    @Test
    public void verifyElementsSection(){
        homepage.clickOnElementsLink();
        Reporter.reportStep("Able to click on Elements Link");

    }


}
