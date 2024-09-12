package com.pages.demoqa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ElementsPage extends BasePage{


    public ElementsPage(WebDriver driver, String uiwait, String timeout) {
        super(driver, uiwait, timeout);
        PageFactory.initElements(driver, this);

    }

    public void handleWebTable(){


    }
}
