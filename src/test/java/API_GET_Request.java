import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class API_GET_Request {
	
	@Test
	public void getListUserReqRes() {
		
		//Specify Base URI
		RestAssured.baseURI="https://reqres.in/api/users";
		
		//Request Object
		RequestSpecification httpRequest = RestAssured.given();
		
		//Response Object
		String param="?page=3";
		
		Response response=httpRequest.request(Method.GET, param);
		
		//Print Response in Console Window
		String responseBody = response.getBody().asString();
		System.out.println("Response body is: " +responseBody);
		
		//Validate Status Code
		int statusCode = response.getStatusCode();
		System.out.println("Status code is: " +statusCode);
		
		Assert.assertEquals(statusCode, 200);
	}
}
