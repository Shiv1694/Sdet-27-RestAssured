package com.Parameters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class QuerryParametertest
{
	@Test
	public void param()
	{
		given()
			.queryParam("page", 2)
		.when()
			.get("http://reqres.in/api/users?page=2")
		.then()
			.assertThat().statusCode(200)
			.log().all();
	}
}
