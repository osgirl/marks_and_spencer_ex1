package uk.co.ms.testing.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * JUnit Runner for running Cucumber stories.
 *
 * @author Carl Jokl
 * @since 08/09/15.
 */
@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:target/cucumber"})
public class CucumberRunner {


}
