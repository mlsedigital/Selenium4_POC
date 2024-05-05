package testRunners;


import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;
import static io.cucumber.junit.platform.engine.Constants.*;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty, " +
        "json:target/JsonReports/cucumber.json, " +
        "html:target/HTMLReports/cucumber.html")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "stepdefinitions, hooks")


public class TestRunner {


}
