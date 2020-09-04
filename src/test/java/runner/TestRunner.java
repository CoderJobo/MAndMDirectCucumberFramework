package runner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import core.TestConfig;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/features"},
        glue = {"step_definitions"},
        plugin = {"pretty", "html:target/cucumber-reports"}
)

public class TestRunner {

    @BeforeClass    // JUnit annotation
    public static void test() throws Exception{
        String env = System.getenv("env").toLowerCase();
        TestConfig.load(env);
        TestConfig.addProperty("browser", System.getenv("browser"));
        TestConfig.addProperty("env", env);
    }
}
