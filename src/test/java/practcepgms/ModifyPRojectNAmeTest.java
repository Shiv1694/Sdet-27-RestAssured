package practcepgms;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class ModifyPRojectNAmeTest 
{
	@Test
	public void modify()
	{
		given()
			.body(null)
		when()
			.put("http://localhost:8084/projects/TY_PROJ_004")
		.then()
			.assertThat().statusCode(201)
			.assertThat().contentType(ContentType.JSON)
			//.assertThat().time(Matchers.lessThan(300L), TimeUnit.MILLISECONDS)
			.log().all();
	}
}
