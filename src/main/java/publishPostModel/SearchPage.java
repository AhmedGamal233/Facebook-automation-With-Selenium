package publishPostModel;

import Actions.UiActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {
	
	public WebDriver browserObject;
	
//	public By firstResult =By.xpath("//div[@class='_77we']//img[contains(@src,'3728488348340191232_n.jpg')]");
	public By firstResult =By.xpath("//div[@class='_77we']//img[contains(@src,'100010312230219')]");
	
	
	public SearchPage(WebDriver driver){
		this.browserObject=driver;
	}
	
	public void clickOnFirstResult() {
	
		/*
		 * WebDriverWait wait = new WebDriverWait(browserObject,20);
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(firstResult));
		 * browserObject.findElement(firstResult).click();
		 */
		UiActions.waitUntilVisability(browserObject, firstResult);
		UiActions.click(browserObject, firstResult);
	}

}
