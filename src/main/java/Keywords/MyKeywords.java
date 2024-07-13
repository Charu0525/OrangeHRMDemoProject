package Keywords;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.interactions.Actions;

public class MyKeywords {
	RemoteWebDriver driver;    
	
	
	//this class is for log4j. Also for  import org.apache.log4j.Logger; this only
	//Also we have to create log4j.properties file as LOgger class searches for this file only to store the logs
	
	public static final Logger LOG= Logger.getLogger(MyKeywords.class);

	public void initialiseBrowser(String browserName) {
		if (browserName.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
			LOG.info("Launching Chrome Browser");
		} else if (browserName.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
			LOG.info("Launching Edge Browser");
		} else if (browserName.equalsIgnoreCase("Safari")) {
			driver = new SafariDriver();
			LOG.info("Launching Safari Browser");
		} else if (browserName.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
			LOG.info("Launching Firefox Browser");
		} else {
			LOG.info("Invaid browserName");
		}

	}
	
	

	public String getTitle(String URL) {
		String title = driver.getTitle();

		return title;
	}

	public void launchURL(String URL) {
		driver.get(URL);
	}

	public void clickOnElement(String element) {
		driver.findElement(By.xpath(element)).click();
	}

	public void sendText(String element, String text) {
		driver.findElement(By.xpath(element)).sendKeys(text);
	}

	public void loginButton(String element) {
		driver.findElement(By.xpath(element)).click();

	}

	public String getText(String element) {
		String msg = driver.findElement(By.xpath(element)).getText();
		return msg;

	}

	public void waitMethod() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	public String verifyValidLogin(String element) {
		String dashboardTitle = driver.findElement(By.xpath(element)).getText();
		return dashboardTitle;

	}

	public void screenshotUsingSelenium() throws IOException {

		File LoginScreenShot = driver.getScreenshotAs(OutputType.FILE);
		File trg = new File(".\\Screeenshots\\usingSelenium" + timestamp()+".jpg");
		FileUtils.copyFile(LoginScreenShot, trg);//
	}

	public String timestamp() {
		return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());

	}
	
	public void tearDown() {
		driver.quit();

	}
	
	public void scrollDownToUser(String element) {
		Actions actions = new Actions(driver);
		WebElement user=driver.findElement(By.xpath(element));
		actions.moveToElement(user);
        actions.perform();
        driver.findElement(By.xpath(element)).click();
        
		
	}
	

}
