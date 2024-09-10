package com.pages.demoqa;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BasePage {

    private WebDriver driver;
    WebDriverWait explicitwait;
    Integer timeout;
    String implicitwait;
    WebElement element;
    private static final Logger logger = LogManager.getLogger(com.pages.amazon.BasePage.class);

    public BasePage(WebDriver driver, String uiwait, String timeout){
        this.driver=driver;
        this.implicitwait=uiwait;
        this.timeout=Integer.parseInt(timeout);
    }



    private void waitFor(ExpectedCondition<WebElement> condition, Integer timeout){
        timeout=timeout!=null?timeout:5;
        explicitwait= new WebDriverWait(driver, timeout);
        explicitwait.until(condition);
    }


    public void enterTextInTextBox(By locator, String inputText){

        waitFor(ExpectedConditions.elementToBeClickable(locator),timeout);
        logger.debug("Entering Textbox at location: "+ locator);
        element= driver.findElement(locator);
        element.click();
        element.clear();
        element.sendKeys(inputText);

    }
    public void enterTextInTextBox(WebElement element, String inputText){

        waitFor(ExpectedConditions.elementToBeClickable(element),timeout);
        logger.debug("Entering Textbox at location: "+ element.getLocation());
        element.click();
        element.clear();
        element.sendKeys(inputText);

    }

    public String getTextAt(By locator){
        String getTextValue=null;
        logger.debug("Getting Text value from: "+ locator);
        waitFor(ExpectedConditions.visibilityOfElementLocated(locator),timeout);
        getTextValue= driver.findElement(locator).getText();
        return getTextValue;
    }


    public String getTextAt(WebElement element){
        String getTextValue=null;
        logger.debug("Getting Text value from: "+ element.getLocation());
        waitFor(ExpectedConditions.visibilityOf(element),timeout);
        getTextValue= element.getText();
        return getTextValue;
    }

    public void clickOnButton(By locator){

        waitFor(ExpectedConditions.elementToBeClickable(locator),timeout);
        logger.debug("Clicking on button at location: "+ locator);
        element= driver.findElement(locator);
        element.click();
    }

    public void clickOnButton(WebElement element){

        waitFor(ExpectedConditions.elementToBeClickable(element),timeout);
        logger.debug("Clicking on button at location: "+ element.getLocation());
        element.click();
    }

    public boolean isElementPresentWithImplicit(By locator) throws InterruptedException{
        try {
            logger.debug("Checking for element is present at location: "+ locator);
            Thread.sleep(3000);
            driver.manage().timeouts().implicitlyWait(Long.parseLong("2"), TimeUnit.SECONDS);
            driver.findElement(locator).isDisplayed();
            driver.manage().timeouts().implicitlyWait(Long.parseLong(implicitwait), TimeUnit.SECONDS);
            return true;
        }
        catch(NoSuchElementException e){
            driver.manage().timeouts().implicitlyWait(Long.parseLong(implicitwait), TimeUnit.SECONDS);
            return false;
        }
    }


    public boolean isElementPresent(By locator) throws InterruptedException{
        try {
            logger.debug("Checking for element is present at location: "+ locator);
            Thread.sleep(5000);
            driver.findElement(locator).isDisplayed();
            return true;
        }
        catch(NoSuchElementException e){
            return false;
        }
    }


    public void waitForPageLoad(){
        ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(pageLoadCondition);


    }




}
