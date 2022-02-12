package Practice_CRUD_Without_BDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateProject 
{
	@Test
	public void createProject()
	{
	//Step 1:create testdata
		JSONObject jObj=new JSONObject();
		jObj.put("createdBy","BhenkBabu");
		jObj.put("projectName", "Apple");
		jObj.put("status","Ongoing" );
		jObj.put("teamSize",000 );
		
		//step 2:provide request specifcation
		RequestSpecification req = RestAssured.given();
		req.contentType(ContentType.JSON);
		req.body(jObj);
		
		//step 3:perform the action
		Response resp = req.post("http://localhost:8084/addProject");
		
		//step 4: print n console and verify
		System.out.println(resp.asString());	
		System.out.println(resp.prettyPrint());
		System.out.println(resp.prettyPeek());
		System.out.println(resp.contentType());
	
	}
}
