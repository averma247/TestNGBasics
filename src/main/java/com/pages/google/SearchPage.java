package com.pages.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage extends BasePage{
	

	public SearchPage(WebDriver driver, String wait, String exwait) {
		// TODO Auto-generated constructor stub
		super(driver,wait,exwait);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//textArea[@title='Search']")
	WebElement searchTextBox;
	
	
	
	public void searchText(String searchText) {
		enterTextInTextBox(searchTextBox, searchText);
	}

}
