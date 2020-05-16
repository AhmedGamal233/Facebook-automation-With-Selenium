package publishPostModel;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Actions.UiActions;
public class Profile {

	
public WebDriver browserObject;
	
	public By message =By.xpath("//div[@id='pagelet_timeline_profile_actions']//a[@rel='dialog'][contains(.,'Message')]");
	public By messagebar=By.xpath("//div//textarea[@name='message_body']");
	public By messagebar2=By.xpath("//*[@class='_5rpb']//*[@role='combobox']");
	public Profile(WebDriver driver){
		this.browserObject=driver;
	}
	
	public void clickOnMessage() {
		
		((JavascriptExecutor)browserObject).executeScript("window.scrollBy(0,500)");
		/*
		 * WebDriverWait wait = new WebDriverWait(browserObject,20);
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(message));
		 * browserObject.findElement(message).click();
		 */
		UiActions.waitUntilVisability(browserObject, message);
		UiActions.click(browserObject, message);
	}
	
	public void clickOnMessagebar(String text) {
	//	WebDriverWait wait = new WebDriverWait(browserObject,20);
	//	wait.until(ExpectedConditions.visibilityOfElementLocated(messagebar));
	//	wait.until(ExpectedConditions.visibilityOfElementLocated(messagebar2));
	/*	if(browserObject.findElement(messagebar).isDisplayed())
		{
		browserObject.findElement(messagebar).click();
		browserObject.findElement(messagebar).sendKeys(text);
		browserObject.findElement(messagebar).sendKeys(Keys.ENTER);
		}
		else if (browserObject.findElement(messagebar2).isDisplayed())
		{
			browserObject.findElement(messagebar2).click();
			browserObject.findElement(messagebar2).sendKeys(text);
			browserObject.findElement(messagebar2).sendKeys(Keys.ENTER);
		}*/
	//	browserObject.findElement(messagebar2).click();
		UiActions.waitUntilVisability(browserObject, messagebar2);
		Actions builder = new Actions(browserObject);
		builder.moveByOffset(1085, 630);
		builder.click();
	//	browserObject.findElement(messagebar2).sendKeys(text);
	//	browserObject.findElement(messagebar2).sendKeys(Keys.ENTER);
		UiActions.sendKeys(browserObject, messagebar2, text);
		UiActions.clicOnKeyboardButton(browserObject, messagebar2, Keys.ENTER);
	}
	
}
