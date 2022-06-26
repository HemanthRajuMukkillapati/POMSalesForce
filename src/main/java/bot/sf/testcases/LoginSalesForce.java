package bot.sf.testcases;




import bot.sf.utils.ProjectSpecificMethods;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/main/java/features/TC_000_LoginSalesForce.feature", glue= {"bot.sf.pages"}, monochrome=true,plugin = {"pretty"},publish = true)
public class LoginSalesForce extends ProjectSpecificMethods {


}
