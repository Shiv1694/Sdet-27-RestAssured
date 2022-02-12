package com.Authentcation;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Auth2_Test 
{
	@Test
	public void oauths()
	{
		Response resp=given()
					.formParam("client_id", "BabuSanjay")
					.formParam("client_secret","5f36468b213a62b19a131504d934394f")
					.formParam("grant_type", "client_credentials")
					.formParam("redirect_uri", "http://babukalla.com")
				.when()
					.post("http://coop.apps.symfonycasts.com/token");
		String token=resp.jsonPath().get("access_token");
		
		given()
			.auth().oauth2(token)
			.pathParam("User_Id", "2797")
		.when()
			.post("http://coop.apps.symfonycasts.com/api/{User_Id}/me")
		.then()
			.log().all();
	}
}
