package runner;

import org.junit.runner.RunWith;		
		
import cucumber.api.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@SuppressWarnings("deprecation")
@RunWith(Cucumber.class)				
@CucumberOptions(features="E:\\Cucumber\\com.ccumberBDD.com\\src\\main\\java\\feature",glue={"steps_Defnition"})

public class RunnerClass {


}
