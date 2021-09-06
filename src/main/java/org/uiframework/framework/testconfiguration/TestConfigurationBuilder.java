package org.uiframework.framework.testconfiguration;

import org.openqa.selenium.Dimension;


public class TestConfigurationBuilder {

    private BrowserType Browser;
    private ExecutionMode Mode =ExecutionMode.HEADFULL;
    private ExecutionPrivacy Privacy = ExecutionPrivacy.PUBLIC;
    private Dimension BrowseDimensions;
    private BrowserSize size;
    private Integer ImplicitWait;



    public TestConfigurationBuilder setExecutionMode(ExecutionMode Mode) {
        this.Mode= Mode;
        return this;
    }
    public TestConfigurationBuilder setWindowType(ExecutionPrivacy ExecutionPrivacy) {
        this.Privacy = ExecutionPrivacy;
        return this;
    }

    public TestConfigurationBuilder setBrowserCustomDimensions(Integer BrowserWidth,Integer BrowserHeight ) {
         this.BrowseDimensions = new Dimension(BrowserWidth,BrowserHeight);
        return this;
    }
    public TestConfigurationBuilder setBrowserCustomDimensions(BrowserSize size) {
        this.size=size;
        return this;
    }


    public TestConfigurationBuilder setBrowser(BrowserType Browser ) {
        this.Browser= Browser;
        return this;
    }
    public TestConfigurationBuilder setImplicitWait(Integer ImplicitWait ) {
        this.ImplicitWait= ImplicitWait;
        return this;
    }

    public TestConfiguration Build()
    {
        return new TestConfiguration(Browser, Privacy,BrowseDimensions,size, Mode,ImplicitWait);
    }

}
