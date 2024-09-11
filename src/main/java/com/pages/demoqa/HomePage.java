package com.pages.demoqa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver, String uiwait, String timeout) {
        super(driver, uiwait, timeout);
        // TODO Auto-generated constructor stub
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//h5[text()='Elements']")
    WebElement elementXpathOptions;


    public void clickOnElementsLink(){
        waitForPageLoad();
        scrollToElement(elementXpathOptions);
        clickOnButton(elementXpathOptions);
    }

}
