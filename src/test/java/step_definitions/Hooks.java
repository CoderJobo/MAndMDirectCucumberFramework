package step_definitions;

import core.DriverFactory;
import core.TestConfig;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    private DriverFactory driverFactory = null;

    @Before // Cucumber annotation
    public void initBrowser(){
        driverFactory = new DriverFactory();
        BaseSteps.setDriver(driverFactory.getDriver(TestConfig.getProperty("browser")));
    }

    @After  // Cucumber annotation
    public void closeBrowser(){
        driverFactory.quitDriver();
    }

}
