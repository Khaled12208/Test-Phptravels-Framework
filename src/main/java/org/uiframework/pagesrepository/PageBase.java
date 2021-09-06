package org.uiframework.pagesrepository;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;


public class PageBase {

    /** Global Variables **/
    public WebDriver driver;
    public JavascriptExecutor js;

    /** Constructor to init the web driver and java executor **/
    public PageBase(WebDriver webDriver)
    {

	this.driver = webDriver;
	this.js = ((JavascriptExecutor) driver);

    }

    /** Common Function across testing process **/
    // Click on Element
    public void ClickElement(WebElement Element) {

	Element.click();
    }

    // Send Text to Element
    public void SendKeys(WebElement Element, String values) {

	Element.sendKeys(values.trim());
    }

    // Send Text to Element
    public void SendKeys(WebElement Element, Keys modifierKey) {

	Element.sendKeys(modifierKey);
    }

    // Handling Drop down Selection by value
    public void SelectByValue(WebElement Element, String values) {
	Select s = new Select(Element);
	s.selectByValue(values);

    }

    // Handling Drop down Selection by Index
    public void SelectByIndexe(WebElement Element, int values) {
	Select s = new Select(Element);
	s.selectByIndex(values);

    }

    // Handling Drop down Selection by Visual Text
    public void SelectByVisualText(WebElement Element, String values) {
	Element.click();
	Select s = new Select(Element);
	s.selectByVisibleText(values);
    }

    // Extracting text from web Element
    public String GetText(WebElement Element) {

	return Element.getText();

    }

    // Check if Element is Displayed
    public boolean isDisplayed(WebElement Element) {

	return Element.isDisplayed();

    }

    public void changeWindowsSizeTo(String WindowWidth,String WindowHeight)
    {
        Dimension WindowDimension = new Dimension(Integer.parseInt(WindowWidth), Integer.parseInt(WindowHeight));
        driver.manage().window().setSize(WindowDimension);
    }

    public int getWindowsWidth(WebDriver driver)
    {
        return driver.manage().window().getSize().width;
    }

    public int getWindowsHigh(WebDriver driver)
    {
        return driver.manage().window().getSize().height;
    }

    public void AssertCurrentURLis(String URL)
    {
        Assert.assertTrue(URL.equalsIgnoreCase(driver.getCurrentUrl()));

    }
    public void AssertPostionOfElement(WebElement Elment,int x ,int y)
    {
        Assert.assertEquals(x,Elment.getLocation().getX());
        Assert.assertEquals(y,Elment.getLocation().getY());
    }


    public void AssertCurrentWidowSizeis(String URL)
    {
        driver.getCurrentUrl().equalsIgnoreCase(URL);
    }

    public void NavigateBack()
    {
        driver.navigate().back();

    }




}
