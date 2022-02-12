package Practice_CRUD_Without_BDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class UpdateProject
{

	@Test
	public void updateProject()
	{
		JSONObject jObj = new JSONObject();
		jObj.put("createdBy","BhenkiBabu");
		jObj.put("projectName", "Apple");
		jObj.put("status","Ongoing" );
		jObj.put("teamSize",111 );
		
		//step 2
		RequestSpecification req = RestAssured.given();
		req.contentType(ContentType.JSON);
		req.body(jObj);
		
		//step 3 
		Response resp = req.put("http://localhost:8084/projects/TY_PROJ_402");
		
		//step 4 verify
		ValidatableResponse validate = resp.then();
		validate.assertThat().statusCode(200);
		validate.log().all();
	}
}
