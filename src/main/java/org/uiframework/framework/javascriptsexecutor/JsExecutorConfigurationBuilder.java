package org.uiframework.framework.javascriptsexecutor;

import org.openqa.selenium.WebDriver;


public class JsExecutorConfigurationBuilder {

    private  WebDriver Driver;
    private  String Script;
    private  Object args = null;


    public JsExecutorConfigurationBuilder (WebDriver Driver) {
        this.Driver= Driver;
    }
    public JsExecutorConfigurationBuilder WithScriptFromFile (String javaScriptFile) {

        return this;
    }
    public JsExecutorConfigurationBuilder withArgument (Object args) {
        this.args=args;
        return this;
    }

    public JsExecutorConfiguration Build()
    {
        return new JsExecutorConfiguration(Driver, Script, args);
    }

}
