package nz.co.aainsurance;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 * The Class TestRunner.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/",
		
		glue = {"nz.co.aainsurance.steps"},
		plugin = {
				"html:target/cucumber-html-report", "json:target/cucumber.json", "pretty:target/cucumber-pretty.txt",
				"usage:target/cucumber-usage.json", "junit:target/cucumber-results.xml" }
	)

public class AAInsuranceBDDTest {

}