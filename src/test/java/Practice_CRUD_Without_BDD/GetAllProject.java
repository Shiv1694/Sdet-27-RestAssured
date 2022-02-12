package Practice_CRUD_Without_BDD;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAllProject 

{
	@Test
	public void getAllProjects()
	{
		//step 1
		int expstatus=200;
		Response resp = RestAssured.get("http://localhost:8084/projects");
		
		
		//step2
		System.out.println(resp.prettyPrint());
		int actstatus = resp.getStatusCode();
		Assert.assertEquals(expstatus, actstatus);
		
	}
}
