package practiceTest;

import org.testng.annotations.Test;

import PojoLibrary.PojoEmpClassTest;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateUSerWithInvalidMobileNumTest 
{
	@Test
	public void CreateUSerWithInvalidMobileNum()
	{
		PojoEmpClassTest pObj = new PojoEmpClassTest("SDET", "25/05/1999", "nithesh@gmail.com", "nithesh", 15, "9888777657111", "hdfc", "ROLE_ADMIN", "nithesh");
		
		given()
			.body(pObj)
		.when()
			.post("http://localhost:8084/employees")
		.then()
			.assertThat().statusCode(422)
			.contentType(ContentType.JSON)
			.log().all();
	}
}
