package practiceTest;

import java.util.Random;

import org.testng.annotations.Test;

import PojoLibrary.PojoClass;
import PojoLibrary.PojoEmpClassTest;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class CreateProjAndAllocateToEmpTest
{
	@Test
	public void createProjAndAllocateToEmp() {
	Random randNum = new Random();
	int ranNum=randNum.nextInt();
	String projName="LetIn"+ranNum;
	String empName="kumar"+ranNum;
	PojoClass poj = new PojoClass("sharanu", projName, "completed", 25);
	
	
	 Response resp = given()
		.body(poj)
		.contentType(ContentType.JSON)
	.when()
		.post("http://localhost:8084/addProject");
	 
	 String res = resp.jsonPath().get("projectName");
	 PojoEmpClassTest emp_Pojo = new PojoEmpClassTest("SDET", "25/05/1999", "nithesh@gmail.com", "nithesh", 15, "9888777657", res, "ROLE_ADMIN", empName);
	 given()
	 	.body(emp_Pojo)
	 	.contentType(ContentType.JSON)
	 .when()
	 	.post("http://localhost:8084/employees")
	 .then()
	 	.assertThat().statusCode(201)
	 	.contentType(ContentType.JSON)
	 	.log().all();
	}
}
