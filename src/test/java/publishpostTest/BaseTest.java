package publishpostTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.applitools.eyes.MatchLevel;
import com.applitools.eyes.selenium.Eyes;

//import Actions.UiActions;
import publishPostModel.LogIn;
import publishPostModel.Home;
import publishPostModel.SearchPage;
import publishPostModel.Profile;
public class BaseTest {
	
public WebDriver browserObject;
protected LogIn login;
protected Home  home;
protected SearchPage search;
protected Profile profile;
protected VisualTestManger eyeManger;


//you must run from testng.xml right click on it and run testNG suite

@Parameters ("BrowserType")
 @BeforeClass
 public void BeforeClass(String BrowserType) {
	 
  //   actions.initiateBrowser(browserObject);
	
	 if (BrowserType.equalsIgnoreCase("Firefox")) 
		{
			System.setProperty("webdriver.gecko.driver","src\\test\\resources\\drivers\\geckodriver.exe");
			FirefoxOptions options = new FirefoxOptions();
		     options.addArguments("--disable-notifications");
			browserObject = new FirefoxDriver (options);
			
			
		}
		else if (BrowserType.equalsIgnoreCase("Chrome")) 
		{
	 System.setProperty("webdriver.chrome.driver","src\\test\\resources\\drivers\\chromedriver.exe");
	 ChromeOptions options = new ChromeOptions();
     options.addArguments("--disable-notifications");
    browserObject = new ChromeDriver(options);
     
    

		}
	 eyeManger =new VisualTestManger(browserObject);
	 login = new LogIn(browserObject);
	 home = new Home(browserObject);
	 search =new SearchPage(browserObject);
	 profile =new Profile(browserObject);
	 browserObject.manage().window().maximize();
	 
	 
	 
 }
 
 
 @AfterClass
 public void AfterClass() {
	 browserObject.quit();
	eyeManger.abort(); //to make sure that eye session not hang
 }
 

}
