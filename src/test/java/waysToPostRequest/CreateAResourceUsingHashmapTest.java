package waysToPostRequest;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateAResourceUsingHashmapTest {

	@Test
	public void create() {
	
		HashMap map = new HashMap();
		
		map.put("createdBy", "kumar");
		map.put("projectName", "Larraclassified");
		map.put("status", "completed");
		map.put("teanSize", 001);
		
		given()
			.body(map)
			.contentType(ContentType.JSON)
		.when()
			.post("http://localhost:8084/addProject")
		.then()
			.assertThat().statusCode(201)
			.contentType(ContentType.JSON)
			.log().all();
}
}
