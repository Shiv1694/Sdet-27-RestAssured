package com.Authentcation;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class BearerTokenTest 
{
	@Test
	public void bearerAuth()
	{
		given()
			.auth().oauth2("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")
		.when()
			.get("https://api.github.com/user/repos");
		
			
	}
	
}
