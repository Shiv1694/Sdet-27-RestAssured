package com.Parameters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class PathParameterTest 
{
	@Test
	public void param()
	{
		given()
			.pathParam("projectId","TY_PROJ_602")
		.when()
			.delete("http://localhost:8084/projects/{projectId}")
		.then()
			.assertThat().statusCode(204)
			.log().all();
			
		
	}
}
