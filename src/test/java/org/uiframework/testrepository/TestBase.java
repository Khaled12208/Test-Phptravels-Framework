package org.uiframework.testrepository;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.uiframework.framework.datahandler.DataFileFactory;
import org.uiframework.framework.testconfiguration.*;
import org.uiframework.framework.webdriverfactory.DriverFactory;

public class TestBase
{
    public WebDriver driver;
    public DataFileFactory factory = new DataFileFactory(TestBase.class);

    @BeforeTest(alwaysRun = true)
    public void Browser_Init() throws Exception {
        TestConfiguration config=  new TestConfigurationBuilder()
                .setBrowser(BrowserType.CHROME)
                .setBrowserCustomDimensions(BrowserSize.MAX)
                .setExecutionMode(ExecutionMode.HEADFULL)
                .Build();
        this.driver =new DriverFactory(config).OpenBrowser();
        driver.get("https://www.phptravels.net/");
    }

    @AfterTest(alwaysRun = true)
    public void Browser_Termination() {

        driver.quit();
    }


}
