package bot.sf.base;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;



import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;







public class BaseSF extends DriverInstance {
	
	
	public static Properties prop;
	
	
	@BeforeMethod
	public void preCondition() throws IOException {
		
		
		//property
		prop = new Properties();
		FileInputStream propFile = new FileInputStream(new File("./src/main/resources/Application.Properties"));
		prop.load(propFile);
		setDriver(prop.getProperty("browser"), Boolean.parseBoolean((prop.getProperty("headLess"))));
		getDriver().get(prop.getProperty("url"));
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
	}
	
	@AfterMethod
	public void closeBrowser() {
		getDriver().close();

	}

	
	
	
}
