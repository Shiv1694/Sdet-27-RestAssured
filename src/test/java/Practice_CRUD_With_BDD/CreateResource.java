package Practice_CRUD_With_BDD;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateResource
{
	@Test
	public void create()
	{
		
		Random ran=new Random();
		int randomnumber=ran.nextInt(600);
		
		JSONObject jobj = new JSONObject();//json simple dependency
		jobj.put("createdBy", "BabuDon"+randomnumber);
		jobj.put("projectName", "RedSandalwood");
		jobj.put("status","ongoing" );
		jobj.put("teamSize", 11);
		
	
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
