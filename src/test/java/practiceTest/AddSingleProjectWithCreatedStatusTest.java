package practiceTest;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import org.hamcrest.Matchers;
import java.util.concurrent.TimeUnit;

public class AddSingleProjectWithCreatedStatusTest
{
	@Test
	public void created()
	{
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy","dadaa");
		jobj.put("projectName", "Dreamfiretek");
		jobj.put("status", "created");
		jobj.put("teamSize", 9);
		
		given()
			.body(jobj)
			.contentType(ContentType.JSON)
		.when()
			.post("http://localhost:8084/addProject")
		.then()
			.assertThat().statusCode(201)
			.contentType(ContentType.JSON)
			.assertThat().time(Matchers.lessThan(3000L), TimeUnit.MILLISECONDS)
			.log().all();
	}
}
