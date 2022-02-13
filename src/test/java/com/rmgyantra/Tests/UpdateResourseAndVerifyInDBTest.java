package com.rmgyantra.Tests;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import GenericUtility.BaseAPIClass;
import GenericUtility.EndPoints;
import PojoLibrary.PojoClass;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UpdateResourseAndVerifyInDBTest extends BaseAPIClass
{
	@Test
	public void updateAndVerify() throws Throwable
	{
	//Step 1: Create test data
		PojoClass pLib=new PojoClass("BabuKalla", "GudbudIcecream"+jLib.getRandomNum(), "completed", 120);
		
		//Step 2: execute post request
		Response resp = given()
			.body(pLib)
			.contentType(ContentType.JSON)
		.when()
			.post(EndPoints.createProject);
		
		//Step 3: capture the project idfrom response
		String expData = rLib.getJSONData(resp, "projectId");
		System.out.println(expData);
		
		//Step 4: verfy in db
		String query="select * from project;";
		String actData = dLib.executeQueryAndGetData(query, 1, expData);
			Reporter.log(actData, true);
			
			//Step 5: valdate
			Assert.assertEquals(expData,actData);
			Reporter.log("data verification successful", true);
	}
	
}
