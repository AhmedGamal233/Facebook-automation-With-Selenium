package publishpostTest;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.MatchLevel;
import com.applitools.eyes.selenium.Eyes;

public class VisualTestManger {
	
	private WebDriver browserObject;
	private Eyes eyes;
	
	public VisualTestManger(WebDriver driver ) {
		
		this.browserObject=driver;
		
	     Properties props = System.getProperties();
	        try {
	            props.load(new FileInputStream(new File("Config/config.properties")));
	        } catch(Exception e) {
	            e.printStackTrace();
	            System.exit(-1);
	        }
		 
	    eyes = new Eyes();
	    eyes.setApiKey(System.getProperty("applitools.api.key"));
	}
	//Setting the batch name is how you define a test suite with Eyes.
	 public void setBatchName(String batchName){
	        eyes.setBatch(new BatchInfo(batchName));
	    }
	

	 
	 public void validateWindow(){
		    eyes.open(browserObject, "Facebook", Thread.currentThread().getStackTrace()[2].getMethodName());
		    eyes.setMatchLevel(MatchLevel.STRICT);//set mtach level bt enum MachLevel.***
		//   eyes.setForceFullPageScreenshot(true); //to capture all Long Dom 
		    //eyes.checkElement(locator); //to cheack specific element
		    eyes.checkWindow();
		    eyes.close();
		}
	 
	   public void abort(){
	        eyes.abortIfNotClosed();
	    }

}
