package bot.sf.base;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverInstance extends AbstractTestNGCucumberTests  {
	
//created this to avoid driver as static and can run tests parallel with cucumber
	private static final ThreadLocal<RemoteWebDriver> remoteWebdriver = new ThreadLocal<RemoteWebDriver>();
	private static final ThreadLocal<WebDriverWait> wait = new  ThreadLocal<WebDriverWait>();

	public void setWait() {
		wait.set(new WebDriverWait(getDriver(), Duration.ofSeconds(30)));
	}

	public WebDriverWait getWait() {
		return wait.get();
	}

	public void setDriver(String browser, boolean headless) {		
		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized"); 
			options.addArguments("--disable-notifications"); 
			options.addArguments("--incognito");
			remoteWebdriver.set(new ChromeDriver(options));
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions opt1 = new FirefoxOptions();
			opt1.addArguments("--start-maximiz"); 
			opt1.addArguments("--disable-notifications"); 
			opt1.addArguments("--incognito");			
			remoteWebdriver.set(new FirefoxDriver());
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			remoteWebdriver.set(new EdgeDriver());
		default:
			break;
		}
	}
	public RemoteWebDriver getDriver() {
		return remoteWebdriver.get();
	}
	
}
