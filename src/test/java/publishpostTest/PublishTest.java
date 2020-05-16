package publishpostTest;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import org.apache.log4j.*;
import org.apache.log4j.spi.Configurator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;







public class PublishTest extends BaseTest {
	
//to get credentials from property file	
 @DataProvider(name = "data_provider")
 public Object[][] data_provider()
 {
    File file = new File("Config/config.properties");
	FileReader reader = null;
	try {
		reader = new FileReader(file);
	} catch (FileNotFoundException e1) {
		System.out.println("file not found");
		e1.printStackTrace();
	}
    Properties prop =new Properties();
	 try {
		prop.load(reader);
	} catch (IOException e) {
		System.out.println("file not read");
		e.printStackTrace();
	}

	 Object[][] data =new Object[3][2];
	 for(int i=0;i<data.length;i++)
	 {
	 data[i][0]= prop.getProperty("email");
	 data[i][1]= prop.getProperty("password");
	 
	 }
	 return data;
 }
	
//to get credentials from XML file	
 
/*	@DataProvider(name = "data_provider")
	 public Object[][] data_provider()
	 {
		Object[][] xml_data =new Object[3][2];
		try {
		File file = new File("Config/xml_data.xml");
		DocumentBuilderFactory xmld = DocumentBuilderFactory.newInstance();
		DocumentBuilder	xmlBuilder = xmld.newDocumentBuilder();
		Document	domxml = xmlBuilder.parse(file);
		  
		//domxml.getDocumentElement().normalize();
		NodeList childNodes = domxml.getDocumentElement().getChildNodes();
		
		for(int i=0;i<xml_data.length;i++)
		 {   
			 Element element = (Element)(domxml.getElementsByTagName("root").item(0));
			 xml_data[i][0]= element.getElementsByTagName("email").item(0).getTextContent();
			 xml_data[i][1]= element.getElementsByTagName("password").item(0).getTextContent();
		 
		 }
		
	/*	for(int i=0,j=1;(i<xml_data.length & j<childNodes.getLength());i++,j++)
		 { 
			 if (childNodes.item(j).getNodeType() == Node.ELEMENT_NODE) {
			Element element = (Element) (childNodes.item(j));
			 if (element.getNodeName().contains("user"+2)) {
				 xml_data[i][0]= element.getElementsByTagName("email").item(0).getTextContent();
				 xml_data[i][1]= element.getElementsByTagName("password").item(0).getTextContent();
	            }
	     }
		 }*/
	/*		} catch (Exception e) {
				System.out.println("error");
				e.printStackTrace();
			}
		return xml_data;
	 }*/
	 
	
//to get credentials from Json file	
/*	  @DataProvider(name = "data_provider")
	 public Object[][] data_provider()
	 {
		Object[][] json_data =new Object[3][2];
		try {	

			JSONParser parser = new JSONParser();
			 FileReader reader = new FileReader("Config/json_data.json");
	         // JSONObject jsonObject = (JSONObject) parser.parse(reader);
			// JSONObject users = (JSONObject) jsonObject.get("users");
			 
			/*  for(int i=0;i<json_data.length;i++)
				 { 
			     json_data[i][0]= users.get("email");
				 json_data[i][1]= users.get("password");
				 }*/
			 
			 //to loop on array of  jeson objects
/*			 JSONObject jsonObject = (JSONObject) parser.parse(reader);
			 JSONObject authentication = (JSONObject) jsonObject.get("authentication");
			 JSONArray getUsersArray = (JSONArray) authentication.get("users");
			
			 
for (int i =0,j=0;(i < getUsersArray.size() & j<json_data.length); i++,j++) {
	
	JSONObject email_password1 =(JSONObject) getUsersArray.get(0);
	
	json_data[j][0]= email_password1.get("email");
	json_data[j][1]= email_password1.get("password");
	
	}

			 
			  
		} catch (Exception e) {
			System.out.println("error");
			e.printStackTrace();
		}
	return json_data;
 } */

//to get credentials from DataBaseTable [sql server]
/*	  @DataProvider(name = "data_provider")
		 public Object[][] data_provider() throws SQLException, ClassNotFoundException
		 {
			Object[][] sql_data =new Object[3][2];
		   Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			ResultSet result = null;
			Connection connect= null;
			Statement state =null;
				try {
					//you must put in C:\Program Files\Java\jdk-13.0.1\bin Authentication file sqljdbc_auth.dll
						connect= DriverManager.getConnection("jdbc:sqlserver://localhost;integratedSecurity=true;");
						state=connect.createStatement();
						result = state.executeQuery("SELECT [email],[password] FROM [QA40_Company].[dbo].[crediential] where id=1");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
					 for(int i=0;i<sql_data.length;i++)
					 {
						 if(result.next())
						 {
						sql_data[i][0]= result.getString(1);
						
						 sql_data[i][1]=result.getString(2);
						
						 }
						 else
						 {
							 System.out.println("row is not exist"); 
						 }
						 
					 
					 }
			
			return sql_data;
		 }*/
	
 
 //test case with logs
  @Test (dataProvider = "data_provider" )
  public void assertOnLogin(String email,String password) {
	  
	 // Logger log = Logger.getLogger(PublishTest.class.getName());
	 // Logger log = Logger.getLogger(PublishTest.class);
	  Logger log = Logger.getLogger("FaceBookLogger");
	//  BasicConfigurator.configure();
	 PropertyConfigurator.configure("Config/config.properties"); //to read from properity file
	  login.navigateToUrl();
	  log.debug("Navigate to Face book");
	  AssertJUnit.assertTrue(login.emailElementIsDisplayed());
	  log.debug("Assert On emailElementIsDisplayed");
	  login.enterEmail(email);
	  log.debug("enter the email");
	  AssertJUnit.assertTrue(login.passwordElementIsDisplayed()); 
	  log.debug("Assert On PasswordElementIsDisplayed");
	  login.enterPassword(password);
	  log.debug("enter the password");
	  login.loginToprofile();
     AssertJUnit.assertTrue(home.homePageDisplay());
     eyeManger.validateWindow();// eye visual testing
	  
  }
  

@Test
  public void assertPost()
  {
   
	 home.writePost("hello, from the other side");
	 home.clickOnPost();

  }
 
 
@Test
public void assertZmessage()
{
	//home.moveToSearchBar();
	home.searchOnPerson("Hagar Abdelwahab");
	//home.writeMessageToFriend("hello");
	search.clickOnFirstResult();
	profile.clickOnMessage();
	profile.clickOnMessagebar("hello,Hager");
	
	
}
  
}
