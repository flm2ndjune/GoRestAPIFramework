package endpoints;

import io.restassured.response.Response;
import payload.User;
import static io.restassured.RestAssured.*;


import base.BaseTest;

public class UserEndPoints {
	
	//create user api
	public static Response createUser(User payload)
	{
		return given()
				.spec(BaseTest.getRequestSpecification())
				.body(payload)
				.when()
				.post("/users");
		
	}

	//List user 
	public static Response getUserById(int userId)
	{
		return given()
				.spec(BaseTest.getRequestSpecification())
				.pathParam("userId", userId)
				.when()
				.get("/users/{userId}");
		
	}
	
	//List all user 
		public static Response getAllUserById()
		{
			return given()
					.spec(BaseTest.getRequestSpecification())
					.when()
					.get("/users");
			
		}
		
	//Update User
	public static Response updateUser(int userId,User payload)
	{
		return given()
				.spec(BaseTest.getRequestSpecification())
				.body(payload)
				.pathParam("userId", userId)
				.when()
				.put("/users/{userId}");
		
	}
	
	//Delete User
	public static Response deleteUser(int userId)
	{
		return given()
				.spec(BaseTest.getRequestSpecification())
				.pathParam("userId", userId)
				.when()
				.delete("/users/{userId}");
		
	}
	
	
}
