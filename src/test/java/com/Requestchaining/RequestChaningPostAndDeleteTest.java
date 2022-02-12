package com.Requestchaining;

import org.testng.annotations.Test;

import PojoLibrary.PojoClass;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.util.Random;

public class RequestChaningPostAndDeleteTest {

	@Test
	public void postAndDelete()
	{
		Random ranNum = new Random();
		int random = ranNum.nextInt();
		PojoClass pojo = new PojoClass("babu", "qqqq"+random,"completed",159);
		//File file = new File("./data.json");
		given()
			.body(pojo)
			  .contentType(ContentType.JSON)
		.when()
			.post("http://localhost:8084/addProject")
		.then()
			.assertThat().statusCode(201)
			  .log().all();
	}
}
