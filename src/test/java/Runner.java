import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


/**
 * Created by alanpanno on 28/05/2017.
 */

@CucumberOptions(features = {"src/test/features"} , glue = "steps")
public class Runner extends AbstractTestNGCucumberTests {
}
