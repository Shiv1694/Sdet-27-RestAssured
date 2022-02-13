package practiceTest;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class ModifyPRojectNAmeTest 
{
	@Test
	public void modify()
	{
		JSONObject jobj = new JSONObject();
		jobj.put("projectName","BGMI");
		
		System.out.println("***Started***");
		given()
			.body(jobj)
			.contentType(ContentType.JSON)
		.when()
			.put("http://localhost:8084/projects/TY_PROJ_004")
		.then()
			.assertThat().statusCode(201)
			.assertThat().contentType(ContentType.JSON)
			.log().all();
	}
}
