package responseValidation;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PojoLibrary.PojoClass;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class VerifyResponseTmeUsingHamcrestTest 
{
	//execute the same request with multple data usng dataprovider
	@Test(dataProvider="getData")
	public void create(String createdBy,String projectName,String status,int teamSize)
	{
		PojoClass pojo = new PojoClass(createdBy, projectName, status, teamSize);
		given()
			.body(pojo)
			.contentType(ContentType.JSON)
		.when()
			.post("http://localhost:8084/addProject")
		.then()
			.assertThat().statusCode(201)
			.contentType(ContentType.JSON)
			.log().all();
		
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] objArray = new Object[2][4];
		objArray[0][0]="BaBu";
		objArray[0][1]="BabuRaJ Bar";
		objArray[0][2]="ongong...";
		objArray[0][3]=200;
		
		objArray[1][0]="Sanjay";
		objArray[1][1]="Sagwani tree";
		objArray[1][2]="planing...";
		objArray[1][3]=420;
		return objArray;
				
	}
}
