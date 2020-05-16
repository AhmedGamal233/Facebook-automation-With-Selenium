package publishPostModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Actions.UiActions;



public class LogIn {



public WebDriver browserObject;
public By email = By.id("email");
public By passWord =By.id("pass");
public By logIn = By.id("loginbutton");
public String url ="https://en-gb.facebook.com/";

public LogIn(WebDriver driver) {
	this.browserObject=driver;
	
}



public void navigateToUrl() {
	
//	browserObject.navigate().to(url);
	UiActions.navigate(browserObject,url);
}

public void enterEmail(String email_address)
{
//	WebDriverWait wait = new WebDriverWait(browserObject,10);
//	wait.until(ExpectedConditions.visibilityOfElementLocated(email));

//	browserObject.findElement(email).sendKeys(email_address);
	
	UiActions.waitUntilVisability(browserObject,email);
	
	UiActions.sendKeys(browserObject,email, email_address);
}


public boolean emailElementIsDisplayed()
{
//	return browserObject.findElement(email).isDisplayed();
	return UiActions.findElementisDisplyed(browserObject,email);
}

public void enterPassword(String user_password)
{
 //	WebDriverWait wait = new WebDriverWait(browserObject,10);
 //	wait.until(ExpectedConditions.visibilityOfElementLocated(passWord));
	UiActions.waitUntilVisability(browserObject,passWord);
//	browserObject.findElement(passWord).sendKeys(user_password);
	UiActions.sendKeys(browserObject,passWord, user_password);
}

public boolean passwordElementIsDisplayed()
{
//	return browserObject.findElement(passWord).isDisplayed();
	return UiActions.findElementisDisplyed(browserObject,passWord);
}
public void loginToprofile()
{
//	browserObject.findElement(logIn).click();
	UiActions.click(browserObject,logIn);

}

}
