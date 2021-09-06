package org.uiframework.framework.javascriptsexecutor;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class JsExecutorConfiguration {

    private final WebDriver Driver;
    private final JavascriptExecutor jsExecutor;
    private final String Script;
    private final Object args;

    protected JsExecutorConfiguration(WebDriver Driver, String Script, Object args) {
        this.Driver=Driver;
        this.jsExecutor= (JavascriptExecutor) Driver ;
        this.Script=Script;
        this.args=args;
    }

    public Object doExecuteScript()
    {
       return jsExecutor.executeScript(Script,args);
    }

    public WebDriver getCurrentWebDriverInstance()
    {
      return Driver;
    }

    public JavascriptExecutor getCurrentJavaScriptExecutorInstance()
    {
        return jsExecutor;
    }






}
