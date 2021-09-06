package org.uiframework.testrepository;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.uiframework.framework.datahandler.DataFile;
import org.uiframework.framework.datahandler.DataFileType;
import org.uiframework.pagesrepository.HomePage;

import java.util.HashMap;

public class HomePageTests extends TestBase{

    HomePage Home;
    DataFile File;
    HashMap<String,String> Data;

    @Test
    public void VerifyWindowsSize() throws Exception {
        File= factory.DataFileType(DataFileType.PROP)
                .FromResourceFile("HomePageData/BrowserInvocationData.properties")
                .Build();
        Data = File.ReadData().getData();
        Home = new HomePage(driver);
        Home.changeWindowsSizeTo(Data.get("Window.Width"),Data.get("Window.Height"));
        Assert.assertEquals(Home.getWindowsWidth(driver), 1000);
        Assert.assertEquals(Home.getWindowsHigh(driver), 750);
    }

    @Test
    public void VerifyMainTabClickable() {
        Home = new HomePage(driver);
        Home.clickFlightsTab();
        Home.clickToursTab();
        Home.clickVisaTab();

    }

    @Test
    public void VerifyLocationOfLogo() {
        Home = new HomePage(driver);
        Home.AssertPostionOfElement(Home.getLogo(),207,63);
    }


    @Test
    public void VerifySignUpNavigation() {
        Home = new HomePage(driver);
        Home.clickSignUp();
        Home.AssertCurrentURLis("https://www.phptravels.net/signup");
    }
    @Test
    public void VerifyLoginNavigation() {
        Home = new HomePage(driver);
        Home.clickLogin();
        Home.AssertCurrentURLis("https://www.phptravels.net/login");
        Home.NavigateBack();
    }


}
