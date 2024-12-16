package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = {"src/test/resources/features/LoginTest.feature","src/test/resources/features/Website.feature"},
    glue = {"com.stepDefinitions"},
    plugin = {"pretty", "html:target/capstone.html",
    		"io.qameta.allure.cucumber5jvm.AllureCucumber5Jvm",},
    monochrome = true 
)
public class TestRunner {
}
