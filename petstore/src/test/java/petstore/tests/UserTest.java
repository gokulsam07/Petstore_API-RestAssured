package petstore.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import petstore.endpoints.UserEndPoints;
import petstore.payloads.UserPOJO;

public class UserTest {
UserPOJO payload;

	@BeforeClass
	public void generateData() {
		payload = new UserPOJO();
		payload.setId(3456); //hashCode generates random data everytime
		payload.setUsername("gokulsam07");
		payload.setFirstName("Gokul");
		payload.setLastName("Saminathan");
		payload.setEmail("gokuls2381@gmail.com");
		payload.setPassword("qwerty@123");
		payload.setPhone("9876543210");	
		

	}
	
	
	@Test(priority=1,enabled=true)
	public void createUserTest() {
		Response response = UserEndPoints.createUser(this.payload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority=2,enabled=true)
	public void getUserTest() {
		Response response = UserEndPoints.getUser(this.payload.getUsername().toString());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	
	@Test(priority=3)
	public void updateUserTest() {
		payload.setFirstName("Edison");
		payload.setLastName("Subiramani");
		
		Response response = UserEndPoints.updateUser(this.payload,this.payload.getUsername().toString());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority=4)
	public void deleteUserTest() {	
		Response response = UserEndPoints.deleteUser(payload.getUsername().toString());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority=5)
	public void getUserAfterDelete() {	
		Response response = UserEndPoints.getUser(payload.getUsername().toString());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 404);
	}
	
}
