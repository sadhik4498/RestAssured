package Second;

import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Autho {
	
	@Test
	void basicauth() {
		RestAssured.useRelaxedHTTPSValidation();
		given()
		.auth().basic("postman","password")
		
		
		.when()
		.get("https://postman-echo.com/basic-auth")
		
		
		.then()
		.statusCode(200)
		.log().all();
	}
	
	@Test(priority = 2)
	void digestauth() {
		RestAssured.useRelaxedHTTPSValidation();
		given()
		.auth().digest("postman","password")
		
		
		.when()
		.get("https://postman-echo.com/basic-auth")
		
		
		.then()
		.statusCode(200)
		.log().all();
	}
	
	@Test(priority = 3)
	void preempetiveauth() {
		RestAssured.useRelaxedHTTPSValidation();
		given()
		.auth().preemptive().basic("postman","password")
		
		
		.when()
		.get("https://postman-echo.com/basic-auth")
		
		
		.then()
		.statusCode(200)
		.log().all();
	}

}
