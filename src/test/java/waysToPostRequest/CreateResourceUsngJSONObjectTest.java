package waysToPostRequest;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateResourceUsngJSONObjectTest
{
	@Test
	public void create()
	{
	 Random ranNum=new Random();
	 
	 JSONObject jobj = new JSONObject();
	 jobj.put("createdBy","Sanjay");
	 jobj.put("projectName", "Huli");
	 jobj.put("status", "completed");
	 jobj.put("teamSize", 100);
	
	 
	 given()
	 	.body(jobj)
	 	.contentType(ContentType.JSON)
	 .when()
	 	.post("http://localhost:8084/addProject")
	 .then()
	 	.assertThat().statusCode(201)
	 	.contentType(ContentType.JSON)
	 	.log().all();
	}
}
