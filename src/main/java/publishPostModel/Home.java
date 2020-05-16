package publishPostModel;



import Actions.UiActions;





import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Home {
	public WebDriver browserObject;
	
	public By postTextPlace =By.name("xhpc_message");
    public By postButton=By.xpath("//button[contains(.,'Post')]");
	public By searchBar =By.name("q");
	public By messageText =By.xpath("//div[@class='_59v1']//div[@data-offset-key][@class]");
	public By messageBar=By.xpath("//div[@class='fbChatSidebarBody'][@role='complementary']");
	public By messageWrite =By.xpath("//div[@class='_1mf _1mj']");
	public By searchButton=By.xpath("//i[@class='_585_']//ancestor::button[@type='submit']");
	public By closePost=By.xpath("//div[@class='_3u17 _3_fz']");
	/*
	 * public By friendTab =By.id("u_0_1i"); public By friendTab
	 * =By.xpath("//span[@class='_55pe'][contains(.,'Friends')]"); public By onlyMe
	 * =By.xpath("//span[@class='_4chl'][contains(.,'Only me')]"); public By
	 * friendSearch =By.xpath("//div[@id='chatsearch']//input[@class='_58al']");
	 * public By searchBar =By.xpath("//input[@data-testid='search_input']"); public
	 * By personImage =By.xpath(
	 * "//div[@direction='left'][@class='clearfix']//img[contains(@src,'71935877_757973494652909_8444524625903222784_o.jpg')]"
	 * );
	 */
	
	
	public Home(WebDriver driver){
		this.browserObject=driver;
	}
	

	
	public boolean homePageDisplay()
	{
		/*
		 * WebDriverWait wait = new WebDriverWait(browserObject,10);
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(postTextPlace));
		 * return browserObject.findElement(postTextPlace).isDisplayed();
		 */
		UiActions.waitUntilVisability(browserObject, postTextPlace);
		
		return UiActions.findElementisDisplyed(browserObject, postTextPlace);
		
	}
	

	public void writePost(String text)
	{
		/*
		 * WebDriverWait wait = new WebDriverWait(browserObject,10);
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(postTextPlace));
		 * browserObject.findElement(postTextPlace).click();
		 * browserObject.findElement(postTextPlace).sendKeys(text);
		 */
		UiActions.waitUntilVisability(browserObject, postTextPlace);
		UiActions.click(browserObject, postTextPlace);
		UiActions.sendKeys(browserObject, postTextPlace, text);
	}
	
	public void clickOnPost() {
		/*
		 * WebDriverWait wait = new WebDriverWait(browserObject,10);
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(postButton));
		 * wait.until(ExpectedConditions.elementToBeClickable(postButton));
		 * browserObject.findElement(postButton).click();
		 * browserObject.findElement(closePost).click();
		 * wait.until(ExpectedConditions.invisibilityOfElementLocated(closePost));
		 */
		
		UiActions.waitUntilVisability(browserObject, postButton);
		UiActions.waitUntilElementBeClickable(browserObject, postButton);
	    UiActions.click(browserObject, postButton);
	    UiActions.click(browserObject, closePost);
	    UiActions.waitUntilVisability(browserObject, closePost);
		
		
	}
	

	
	public void moveToSearchBar()
	{
		Actions builder = new Actions(browserObject);
		builder.moveByOffset(1190, 640);
		
		builder.click();
		
	}
	public void searchOnPerson(String text)
	{
	/*	WebDriverWait wait = new WebDriverWait(browserObject,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(friendSearch));
		
		browserObject.findElement(friendSearch).sendKeys(text);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(personImage));
		
		browserObject.findElement(personImage).click();*/
		
		/*
		 * WebDriverWait wait = new WebDriverWait(browserObject,10);
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(searchBar));
		 * browserObject.findElement(searchBar).sendKeys(text); 
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(searchButton));
		 * browserObject.findElement(searchButton).click();
		 */
		UiActions.waitUntilVisability(browserObject, searchBar);
		UiActions.sendKeys(browserObject, searchBar, text);
		UiActions.waitUntilVisability(browserObject, searchButton);
		UiActions.click(browserObject, searchButton);
		
	}
	
	public void writeMessageToFriend(String text) {
		
		/*
		 * WebDriverWait wait = new WebDriverWait(browserObject,10);
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(messageWrite));
		 * browserObject.findElement(messageWrite).sendKeys(text);
		 */
		UiActions.waitUntilVisability(browserObject, messageWrite);
		UiActions.sendKeys(browserObject, messageWrite, text);
		
	
	}

}
