package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        //features we use to provide the path of all the feature files
        features = "src/test/resources/features/",
        //glue is where we find implementation of gherkin steps
        //we provide the path of package where we defined all the step def
        glue = "steps",
        //if we set the value of dry run to true, it will stop the execution
        //it quickly scans all the gherkin steps in all the feature files and will give
        //you the missing step definition
        //for actual execution, we need to set the value of it to false
        dryRun = false,
        //tags will identify the scenarios in a group and will execute all the scenarios having these tags
        tags = "@test12345",
        //for generating the report
        //pretty is responsible for printing the step and step definition in the console
        //in your framework, all reports should be generated under target folder
        //we will generate html report in target folder
        plugin = {"pretty", "html:target/cucumber.html",
                "json:target/cucumber.json", "rerun:target/failed.txt"}
        //rerun plugin will create failed.txt under target for all failed tc
)



public class RunnerClass {
    //it will be empty
}
