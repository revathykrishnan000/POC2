package pom.qa.rest.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.json.simple.JSONObject;

public class APITest {
	
	//Get method
	@Test(priority=1)
	public void test_userGET(){
		given().when().get("https://reqres.in/api/users/1").
		then().
		assertThat().
		statusCode(200).
		and().		
		body("data.first_name", equalTo("George")).
		and().body("data.last_name", equalTo("Bluth"));	
	}
	
	//Post method
		@Test(priority=2)
		public void test_userPOST(){
			RestAssured.baseURI ="https://reqres.in/api/users";
			RequestSpecification request = RestAssured.given();	
			JSONObject requestParams = new JSONObject();
			 requestParams.put("name", "revathy"); 
			 requestParams.put("job", "tester");			
			 request.body(requestParams.toJSONString());
			 Response response = request.post("/register");			 
			 int statusCode = response.getStatusCode();
			 Assert.assertEquals(statusCode, 201);			 
	}
		//Put method
		@Test(priority=3)
		public void test_userPUT(){
			RestAssured.baseURI ="https://reqres.in/api/users/2";
			RequestSpecification request = RestAssured.given();	
			JSONObject requestParams = new JSONObject();
			 requestParams.put("name", "revathy1");		
			 request.body(requestParams.toJSONString());
			 Response response = request.put("/register");			 
			 int statusCode = response.getStatusCode();
			 Assert.assertEquals(statusCode, 200);			 
	}
		//Put method
				@Test(priority=4)
				public void test_userDELETE(){
					RestAssured.baseURI ="https://reqres.in/api/users/2";
					RequestSpecification request = RestAssured.given();	
					JSONObject requestParams = new JSONObject(); 
					request.body(requestParams.toJSONString());
					Response response = request.delete();					 
					int statusCode = response.getStatusCode();
					Assert.assertEquals(statusCode, 204);			 
			}

}
