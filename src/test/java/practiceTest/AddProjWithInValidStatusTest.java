package practiceTest;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class AddProjWithInValidStatusTest
{
	@Test
	public void createProj() {
		JSONObject jObj = new JSONObject();
		jObj.put("createdBy", "SpiderMan");
		jObj.put("projectName", "BGMI-PUBG");
		jObj.put("status", "completed");
		jObj.put("teamSize", 11);
		
		given()
			.body(jObj)
			.contentType(ContentType.JSON)
		.when()
			.post("http://localhost:8084/addProject")
		.then()
			.assertThat().statusCode(201)
			.contentType(ContentType.JSON)
			.log().all();
			
	}
}
