package petstore.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.response.Response;
import petstore.endpoints.UserEndPoints;
import petstore.payloads.UserPOJO;

public class UserTest {
Faker faker;
UserPOJO payload;
	
	@BeforeClass
	public void generateData() {
		faker = new Faker();
		payload.setId(faker.idNumber().hashCode()); //hashCode generates random data everytime
		payload.setUsername(faker.name().username());
		payload.setFname(faker.name().firstName());
		payload.setLname(faker.name().lastName());
		payload.setEmail(faker.internet().safeEmailAddress());
		payload.setPassword(faker.internet().password(5, 10));
		payload.setPhone(faker.phoneNumber().cellPhone());
	}
	
	
	@Test(priority=1)
	public void createUserTest() {
		Response response = UserEndPoints.createUser(payload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
}