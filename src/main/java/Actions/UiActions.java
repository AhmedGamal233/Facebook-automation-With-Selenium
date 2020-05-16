package Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;









public class UiActions {
	public static  WebDriver browserObject;

//its a helper class to make the most common actions in the frame work
	
	//waiting until element is visable method
	public static void waitUntilVisability (WebDriver browserObject,By by) {
		
		WebDriverWait wait = new WebDriverWait(browserObject,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}
	
	//write in text field method
	public static void sendKeys (WebDriver browserObject,By by ,String string) {
		browserObject.findElement(by).sendKeys(string);
	}
	
	//click method
	public static void click (WebDriver browserObject,By by)
	{
		browserObject.findElement(by).click();
	}
	
	//navigate method
	public static void navigate (WebDriver browserObject,String url)
	{
		browserObject.navigate().to(url);
	}
	
	// assert element existance
	public static boolean findElementisDisplyed(WebDriver browserObject,By by)
	{
	 return	browserObject.findElement(by).isDisplayed();
	}
	
	//waiting until the element disappear method
public static void waitUntilInvisability (WebDriver browserObject,By by) {
		
		WebDriverWait wait = new WebDriverWait(browserObject,20);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
	}
	
	
public static void waitUntilElementBeClickable (WebDriver browserObject,By by) {
	
	WebDriverWait wait = new WebDriverWait(browserObject,20);
	 wait.until(ExpectedConditions.elementToBeClickable(by));
}

public static void clicOnKeyboardButton(WebDriver browserObject, By by, Keys enter) {
	browserObject.findElement(by).sendKeys(Keys.ENTER);
	
}
	
}
