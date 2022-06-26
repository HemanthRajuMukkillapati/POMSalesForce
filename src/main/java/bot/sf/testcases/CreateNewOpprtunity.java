package bot.sf.testcases;




import bot.sf.base.BaseSF;
import io.cucumber.testng.CucumberOptions;






@CucumberOptions(features="src/main/java/features/TC_001_CreateOpprtunity.feature", glue= {"bot.sf.pages"}, monochrome=true,plugin = {"pretty"},publish = true)
public class CreateNewOpprtunity extends BaseSF {

	
}
