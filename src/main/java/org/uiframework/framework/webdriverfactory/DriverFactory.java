package org.uiframework.framework.webdriverfactory;


import org.openqa.selenium.WebDriver;
import org.uiframework.framework.testconfiguration.TestConfiguration;



public class DriverFactory {

    private TestConfiguration configuration;
    private WebDriver driver;
    private String WebURL;

    public DriverFactory(TestConfiguration configuration)
    {
        this.configuration=configuration;

    }

    public WebDriver OpenBrowser() throws Exception {

        if(configuration.getBrowserType()!=null){
            switch (configuration.getBrowserType()) {
                case CHROME:
                    driver = new Chrome().GetBrowser(configuration);
                    driver =  SetupConfig(driver);
                    break;
                case EDGE:
                    driver = new Edge().GetBrowser(configuration);
                    driver =  SetupConfig(driver);
                    break;
                case FIREFOX:
                    driver = new FireFox().GetBrowser(configuration);
                    driver =  SetupConfig(driver);
                    break;
                case IE:
                    driver = new InternetExplorer().GetBrowser(configuration);
                    driver =  SetupConfig(driver);
                    break;
            }
            return driver;
        }else
        {
            throw new Exception(" Unable to create browser driver, make sure to set a browser type");

        }
    }


    private WebDriver SetupConfig(WebDriver driver) throws Exception {

        if (configuration.getBrowserSize()==null && configuration.getBrowseDimensions()!=null){

            driver.manage().window().setSize(configuration.getBrowseDimensions());
        }else if (configuration.getBrowserSize()!=null && configuration.getBrowseDimensions()==null) {
            if (configuration.getBrowserSize().toString().equalsIgnoreCase("MIN")) {
                driver.manage().window().minimize();

            } else {
                driver.manage().window().maximize();
            }
        }
        else if(configuration.getBrowserSize()==null && configuration.getBrowseDimensions()==null) {


        }else
        {
            throw new Exception(" Browser widows size conflict, Please Make sure to provide one way for windows size setting ");

        }
        return driver;
    }

}
