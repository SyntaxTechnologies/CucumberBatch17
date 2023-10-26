package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        //features we use to provide the path of all the feature files
        features = "@target/failed.txt",
        //glue is where we find implementation of gherkin steps
        //we provide the path of package where we defined all the step def
        glue = "steps"
)


public class FailedRunner {
}
