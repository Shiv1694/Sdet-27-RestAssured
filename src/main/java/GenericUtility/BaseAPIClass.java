package GenericUtility;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static io.restassured.RestAssured.*;

public class BaseAPIClass
{
	public DatabaseUtility dLib=new DatabaseUtility();
	public JavaUtilty jLib=new JavaUtilty();
	public RestAssuredUtilty rLib=new RestAssuredUtilty();
	@BeforeSuite
	public void bsConfig() throws Throwable
	{
		baseURI="http://localhost";
		port = 8084;
		
		dLib.connectToDB();
		System.out.println("=====database connection established======");
	}
	
	@AfterSuite
	public void asConfig() throws Throwable
	{
		dLib.closeDB();
		System.out.println("====database connection closed====");
	}
}
