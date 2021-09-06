package org.uiframework.framework.testconfiguration;

import org.openqa.selenium.Dimension;

public class TestConfiguration {

    private final BrowserType Browser;
    private final ExecutionMode Mode;
    private final ExecutionPrivacy Privacy;
    private final BrowserSize size;
    private final Dimension BrowseDimensions;
    private final Integer ImplicitWait;



    protected TestConfiguration(BrowserType browser, ExecutionPrivacy Privacy, Dimension BrowseDimensions, BrowserSize size, ExecutionMode Mode, Integer ImplicitWait) {
        this.size=size;
        this.Privacy = Privacy;
        this.Browser = browser;
        this.BrowseDimensions = BrowseDimensions;
        this.ImplicitWait= ImplicitWait;
        this.Mode=Mode;
    }
    public BrowserSize getBrowserSize() {
        return size;
    }

    public BrowserType getBrowserType() {
        return Browser;
    }

    public ExecutionPrivacy getWindowType() {
        return Privacy;
    }


    public org.openqa.selenium.Dimension getBrowseDimensions() {
        return BrowseDimensions;
    }

    public Integer getImplicitWait() {
        return ImplicitWait;
    }

    public ExecutionMode getExecutionMode() {
        return Mode;
    }
}
