package responseValidation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;

public class DynamcResponseValidatonTest
{
	@Test
	public void verify()
	{
		String expectedProName="RedSandalwood";
	Response response=when()
			.get("http://localhost:8084/projects");
	List<String> proNames = response.jsonPath().get("projectName");
	boolean flag=false;
	for(String pName:proNames)
	{
		if(pName.equals(expectedProName))
		{
			flag=true;
		}
		
	}
	
	response.then()
		.assertThat()
		.contentType(ContentType.JSON).and().statusCode(200)
		.log().all();
	Assert.assertEquals(flag, true);
		
	}
}
