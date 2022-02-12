package com.rmgyantra.Tests;

import org.testng.annotations.Test;

import GenericUtility.BaseAPIClass;
import GenericUtility.EndPoints;
import PojoLibrary.PojoClass;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateResourceAndVerifyInDBTest extends BaseAPIClass
{
	@Test
	public void createResourceAndVerifyInDB()
	{
	//Step 1: Create test data
	PojoClass pLib=new PojoClass("shiv", "Adidas"+jLib.getRandomNum(), "created", 12);
	
	//Step 2: execute post request
	given()
		.body(pLib)
		.contentType(ContentType.JSON)
	.when()
		.post(EndPoints.createProject);
		
	}
}
