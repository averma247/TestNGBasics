package com.pages.amazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver, String uiwait, String timeout) {
		super(driver, uiwait, timeout);
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(id="twotabsearchtextbox")
	WebElement searchTextBox;
	
	@FindBy(id="nav-search-submit-button")
	WebElement searchButton;
	
	@FindBy(xpath="//span[contains(text(),'results')]/following-sibling::*[2]")
	WebElement resultBarText;
	
	public void searchProduct(String searchText) {
		enterTextInTextBox(searchTextBox, searchText);
		clickOnButton(searchButton);
		
	}
	
	public boolean checkResultText(String searchedText) {
		String actualString = getTextAt(resultBarText);
		if(actualString.contains(searchedText))
			return true;
		else
			return false;
	}

}
