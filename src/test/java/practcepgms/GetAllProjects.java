package practcepgms;

import static org.junit.Assert.assertThat;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class GetAllProjects
{
	@Test
	public void getProjs()
	{
		when()
			.get("http://localhost:8084/projects")
		.then()
			.assertThat().statusCode(201)
			.assertThat().time(Matchers.lessThan(1000L), TimeUnit.MILLISECONDS)
			//.assertThat().time(Matchers.lessThan(1000L), TimeUnit.MILLISECONDS)
			.contentType(ContentType.JSON)
			.log().all();
	}
}
