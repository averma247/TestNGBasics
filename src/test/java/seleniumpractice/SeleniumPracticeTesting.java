package seleniumpractice;

import com.pages.demoqa.HomePage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import reports.Reporter;

import java.util.HashMap;

public class SeleniumPracticeTesting extends TestBase{

    HomePage homepage;
    @BeforeClass
    public void setup() {

        homepage= new HomePage(getDriver(), configProp.getProperty("implicitwait"), configProp.getProperty("explicitwait"));

    }

    @Test(enabled = false)
    public void verifyElementsSectionClick(){
        homepage.clickOnElementsLink();
        Reporter.reportStep("Able to click on Elements Link");

    }
    @Test
    public void verifyElementsWebTablesContent(){
        // Create a HashMap
        HashMap<String, String> employeeDetails = new HashMap<>();

        // Add key-value pairs to the HashMap
        employeeDetails.put("firstname", "Cierra");
        employeeDetails.put("lastname", "Vega");
        employeeDetails.put("age", "39");
        employeeDetails.put("email", "cierra@example.com");
        employeeDetails.put("salary", "10000");
        employeeDetails.put("depart", "Insurance");

        // Print the HashMap
        System.out.println(employeeDetails);
        Reporter.reportStep("Employee Details: "+employeeDetails);


    }


}
