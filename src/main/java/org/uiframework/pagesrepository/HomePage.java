package org.uiframework.pagesrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends PageBase{


    private final By flightsTab = By.xpath("//body/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/ul[1]/li[2]/button[1]");
    private final By hotelsTab = By.xpath("//body/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/ul[1]/li[1]/button[1]");
    private final By toursTab = By.xpath("//body/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/ul[1]/li[3]/button[1]");
    private final By visaTab = By.xpath("//body/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/ul[1]/li[4]/button[1]");
    private final By signUp = By.xpath("//header/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/a[1]");
    private final By login = By.xpath("//header/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/a[2]");
    private final By Language = By.xpath("//button[@id='languages']");
    private final By LanguageMenue = By.xpath("//header/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/ul[1]");
    private final By Currency = By.xpath("//button[@id='currency']");
    private final By CurrencyMen = By.xpath("//header/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/ul[1]");
    private final By Agents = By.xpath("//button[@id='agents']");
    private final By AgentsMen = By.xpath("//header/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[4]/div[1]/ul[1]");
    private final By Logo = By.xpath("//header/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]/img[1]");
    private final By headerHomeTab = By.xpath("//header//a[contains(text(),'Home')]");
    private final By headerHotelsTab = By.xpath("//header//a[contains(text(),'Hotels')]");
    private final By headerFlightTab = By.xpath("//header//a[contains(text(),'flights')]");
    private final By headerToursTab = By.xpath("//header//a[contains(text(),'Tours')]");
    private final By headerVisaTab = By.xpath("//header//a[contains(text(),'visa')]");
    private final By headerBlogTab = By.xpath("//header//a[contains(text(),'Blog')]");
    private final By headerOffersTab = By.xpath("//header//a[contains(text(),'Offers')]");
    private final By headerCompanyTab = By.xpath("//header/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/nav[1]/ul[1]/li[8]/a[1]");
    private final By AboutCompanyTab = By.xpath("//header/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]/img[1]");
    private final By TermsOfUseTab = By.xpath("//header/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]/img[1]");
    private final By FAQTab = By.xpath("//header/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]/img[1]");



    public HomePage(WebDriver Driver) {
        super(Driver);
    }

    public void clickFlightsTab() {
        super.ClickElement(driver.findElement(flightsTab));
    }

    public void clickHotelsTab() {
        super.ClickElement(driver.findElement(hotelsTab));
    }

    public void clickSignUp() {
        super.ClickElement(driver.findElement(signUp));
    }

    public void clickToursTab() {
        super.ClickElement(driver.findElement(toursTab));
    }

    public void clickVisaTab() {
        super.ClickElement(driver.findElement(visaTab));
    }

    public WebElement getLogo()
    {
        return driver.findElement(Logo);
    }

    public void clickLogin()
    {
        super.ClickElement(driver.findElement(login));

    }

    public void clickHotelsInBar()
    {
        super.ClickElement(driver.findElement(headerHotelsTab));

    }

}
