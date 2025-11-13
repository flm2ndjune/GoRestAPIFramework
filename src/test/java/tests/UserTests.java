package tests;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import endpoints.UserEndPoints;
import io.restassured.response.Response;
import payload.User;

public class UserTests {
	User userPayLoad;
	int userId;
	@BeforeClass
	public void setUserData()
	{
		String randomEmail = RandomStringUtils.randomAlphanumeric(8).toLowerCase() + "@flm.org";
		
	    userPayLoad=new User();
		userPayLoad.setName("Lokesh");
		userPayLoad.setEmail(randomEmail);
		userPayLoad.setGender("male");
		userPayLoad.setStatus("active");
	}
	
	/*
	 * This test script is to test createUser API 
	 */
	@Test(priority = 1)
	public void createUserTest()
	{
		Response response= UserEndPoints.createUser(userPayLoad);
		
		response.then().log().all();
		
		userId=response.jsonPath().getInt("id");
		
		Assert.assertEquals(response.getStatusCode(), 201);
		Assert.assertEquals(response.jsonPath().get("name"), userPayLoad.getName());
		
	}
	
	/*
	 * This test script is to test get User  API 
	 */
	@Test(priority = 2 , dependsOnMethods = "createUserTest")
	public void getUserByIdTest()
	{
		Response response= UserEndPoints.getUserById(userId);
		
		response.then().log().all();
		
				
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(response.jsonPath().get("name"), userPayLoad.getName());
		Assert.assertEquals(response.jsonPath().get("email"), userPayLoad.getEmail());
		Assert.assertEquals(response.jsonPath().get("status"), userPayLoad.getStatus());
		
	}
	
	/*
	 * This test script is to test update User  API 
	 */
	@Test(priority = 3 , dependsOnMethods = "createUserTest")
	public void updateUserTest()
	{
		userPayLoad.setStatus("inactive");
		Response response= UserEndPoints.updateUser(userId, userPayLoad);
		
		response.then().log().all();
		
				
		Assert.assertEquals(response.getStatusCode(), 200);
		
		Assert.assertEquals(response.jsonPath().get("status"), userPayLoad.getStatus());
		
	}
	
	/*
	 * This test script is to test delete User  API 
	 */
	@Test(priority = 4 , dependsOnMethods = "createUserTest")
	public void deleteUserTest()
	{
		
		Response response= UserEndPoints.deleteUser(userId);
		
		response.then().log().all();
		
				
		Assert.assertEquals(response.getStatusCode(), 204);
		
		
		
	}

}
