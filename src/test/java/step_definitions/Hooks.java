package step_definitions;

import core.DriverFactory;
import core.TestConfig;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    private DriverFactory driverFactory = null;

    @Before // Cucumber annotation
    public void initBrowser(){
        System.out.println("Running @Before...");
        driverFactory = new DriverFactory();
        System.out.println("Browser is " + driverFactory.getDriver(TestConfig.getProperty("browser")));
        BaseSteps.setDriver(driverFactory.getDriver(TestConfig.getProperty("browser")));
    }

    @After  // Cucumber annotation
    public void closeBrowser(){
        System.out.println("Running @After...");
        driverFactory.quitDriver();
    }

}
