package org.uiframework.framework.webdriverfactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.uiframework.framework.testconfiguration.TestConfiguration;

public class InternetExplorer implements Browser{

    private WebDriver driver;

    @Override
    public WebDriver GetBrowser(TestConfiguration config) throws Exception {
        try{
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
            return driver;
        }catch (Exception e)
        {

            throw new Exception(" Please Make Sure that the Internet Explorer Browser is installed in your system : \n "+e.fillInStackTrace());

        }
    }
}
