package Firsttest;

import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class SampleResponce {
	
int id;
	@Test(priority = 1)
	void samplegetreques() {
		RestAssured.useRelaxedHTTPSValidation();
		
		given()
		.when()
			.get("https://reqres.in/api/users?page=2")
		.then()
		.statusCode(200)
		.log().all();
		
	
	}
	
	@Test(priority = 2)
	void createuser() {
		RestAssured.useRelaxedHTTPSValidation();
		HashMap data = new HashMap();
		data.put("name", "morpheus");
		data.put("job" , "leader");
		
		
		id =given()
			.contentType("application/json")
			.body(data)
		
		.when()
			.post("https://reqres.in/api/users")
			.jsonPath().getInt("id");
		
		System.out.println(id);
	}
	
	@Test(priority = 3)
	void Updateuser() {
		RestAssured.useRelaxedHTTPSValidation();
		HashMap data = new HashMap();
		data.put("name", "morpheus");
		data.put("job" , "driver");
		
		
		given()
			.contentType("application/json")
			.body(data)
		
		.when()
			.put("https://reqres.in/api/users/"+id)
			
		.then()
			.assertThat().statusCode(200);
		    
		
		
	}

}
