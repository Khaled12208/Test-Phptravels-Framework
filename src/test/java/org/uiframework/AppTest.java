package org.uiframework;


import org.testng.annotations.Test;
import org.uiframework.framework.datahandler.DataFile;
import org.uiframework.framework.datahandler.DataFileFactory;
import org.uiframework.framework.datahandler.DataFileType;
import org.uiframework.framework.testconfiguration.*;


/**
 * Unit test for simple App.
 */

public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() throws Exception {

        TestConfiguration config=  new TestConfigurationBuilder()
                .setBrowser(BrowserType.CHROME)
                .setBrowserCustomDimensions(BrowserSize.MAX)
                .setExecutionMode(ExecutionMode.HEADFULL)
                .Build();

        DataFile data = new DataFileFactory(AppTest.class)
                .DataFileType(DataFileType.EXCEL)
                .FromResourceFile("UserLogin.xlsx")
                .WithSheetNameOf("Sheet1")
                .Build();
        data.ReadData();
        System.out.println(data.getData());

        DataFile data2 = new DataFileFactory(AppTest.class)
                .DataFileType(DataFileType.JSON)
                .FromResourceFile("UserRegestration.json")
                .Build();
        data2.ReadData();
        System.out.println(data2.getData());

        DataFile data3 = new DataFileFactory(AppTest.class)
                .DataFileType(DataFileType.PROP)
                .FromResourceFile("BrowserInvocationData.properties")
                .Build();
        data3 .ReadData();
        System.out.println(data3.getData());

        DataFile data4 = new DataFileFactory(AppTest.class)
                .DataFileType(DataFileType.XML)
                .FromResourceFile("Datax.xml")
                .Build();
        data4 .ReadData();
       System.out.println(data4.getData());

    }
}
