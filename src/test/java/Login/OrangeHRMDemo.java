package Login;

import java.io.IOException;
import java.sql.Driver;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.sun.tools.sjavac.Log;

import org.apache.log4j.Logger;

import Keywords.Locators;
import Keywords.MyKeywords;


public class OrangeHRMDemo {
	MyKeywords keywords = new MyKeywords();
	
	@BeforeMethod
	public void setUp() {
		keywords.initialiseBrowser("Chrome");
		//System.out.println("Browser has opened");
		keywords.launchURL(Locators.URL);
		//System.out.println("URL has opened");
		keywords.waitMethod();

	}
	@AfterMethod
	public void tearDown(){
		keywords.tearDown();
	}

	@Test(priority = 1)
	public void verifyUserNameRequiredorNot() throws Exception {
		//SoftAssert softAssert = new SoftAssert();

		/*keywords.initialiseBrowser("Chrome");
		keywords.launchURL(Locators.URL);
		
		keywords.waitMethod();
		*/
		//System.out.println("Executing first test case");
		// keywords.fluentWait();
		String userNameErrMsg = "Required";
		keywords.clickOnElement(Locators.USERNAME);
		//System.out.println("Entered Username");
		keywords.sendText(Locators.PASSWORD, "admin123");
		//System.out.println("Entered Password");
		keywords.loginButton(Locators.LOGIN);
		String userNameerr = keywords.getText(Locators.USERNAMEERRMSG);
		
		//softAssert.assertEquals("userNameErrMsg", "userNameerr", "First testcase failed.");

		Assert.assertEquals(userNameErrMsg, userNameerr);
		keywords.screenshotUsingSelenium();
		
		

	}

	@Test(priority = 2)
	public void verifyPasswordRequiredorNot() throws IOException {

		/*keywords.initialiseBrowser("Chrome");
		keywords.launchURL(Locators.URL);
		keywords.waitMethod();
		*/
		
		System.out.println("Executing second test case");
		String passwordErrMsg = "Required";
		keywords.sendText(Locators.USERNAME, "Admin");
		System.out.println("Entered Username");
		keywords.clickOnElement(Locators.PASSWORD);
		System.out.println("Entered Password");
		keywords.loginButton(Locators.LOGIN);
		
		String passwordErr = keywords.getText(Locators.PASSWORDERRMSG);
		Assert.assertEquals(passwordErrMsg, passwordErr);
		keywords.screenshotUsingSelenium();

		

	}

	@Test(priority = 3)
	public void validLogin() throws IOException {
		/*keywords.initialiseBrowser("Chrome");
		keywords.launchURL(Locators.URL);
		keywords.waitMethod();
		*/
		System.out.println("Executing third test case");
		keywords.sendText(Locators.USERNAME, "Admin");
		System.out.println("Entered Username");
		keywords.sendText(Locators.PASSWORD, "admin123");
		System.out.println("Entered Password");
		keywords.loginButton(Locators.LOGIN);
		String dashBoardTitle = keywords.verifyValidLogin(Locators.DASHBOARD);
		String dashTitle = "Dashboard";
		Assert.assertEquals(dashBoardTitle, dashTitle);
		keywords.screenshotUsingSelenium();
		System.out.println("You have logged in Successfully");
		

	}
	
	@Test(priority = 4)
	public void verifyTitle() {
		/*keywords.initialiseBrowser("Chrome");
		keywords.launchURL(Locators.URL);
		keywords.waitMethod();
		*/
		System.out.println("Executing fourth test case");
		keywords.sendText(Locators.USERNAME, "Admin");
		System.out.println("Entered Username");
		keywords.sendText(Locators.PASSWORD, "admin123");
		
		System.out.println("Entered Password");
		keywords.loginButton(Locators.LOGIN);
		String expectedTitle="OrangeHRM";
		String actualTitle=keywords.getTitle(Locators.URL);
		Assert.assertEquals(actualTitle, expectedTitle);
		

	}

	@Test(priority = 5)
	public void verifyMyInfo() {
		/*keywords.initialiseBrowser("Chrome");
		keywords.launchURL(Locators.URL);
		keywords.waitMethod();
		*/
		System.out.println("Executing fifth test case");
		keywords.sendText(Locators.USERNAME, "Admin");
		System.out.println("Entered Username");
		keywords.sendText(Locators.PASSWORD, "admin123");
		System.out.println("Entered Password");
		keywords.loginButton(Locators.LOGIN);
		String expectedMsg = "Personal Details";
		keywords.clickOnElement(Locators.MYINFO);
		keywords.getText(Locators.MYINFO);
		keywords.getText(Locators.PERSONDETAILS);
		String personDetails = keywords.getText(Locators.PERSONDETAILS);
		Assert.assertEquals(personDetails, expectedMsg);
		

	}

	/*
	 * @Test public void verifyUserLeaveDetails() {
	 * keywords.initialiseBrowser("Chrome"); keywords.launchURL(Locators.URL);
	 * keywords.waitMethod(); keywords.sendText(Locators.USERNAME,"Admin");
	 * keywords.sendText(Locators.PASSWORD,"admin123");
	 * keywords.loginButton(Locators.LOGIN);
	 * keywords.clickOnElement(Locators.LEAVETAB);
	 * keywords.scrollDownToUser(Locators.EMPLEAVE);
	 * keywords.clickOnElement(Locators.OPTIONS);
	 * //keywords.clickOnElement(Locators.VIEWLEAVEDETAILS);
	 * 
	 * }
	 */

}
