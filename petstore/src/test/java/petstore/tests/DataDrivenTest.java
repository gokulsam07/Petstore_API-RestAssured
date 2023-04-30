package petstore.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import petstore.endpoints.UserEndPointsUsingPropertiesFile;
import petstore.payloads.UserPOJO;
import petstore.utilities.DataProviderUtil;

public class DataDrivenTest {
	
	@Test(priority=1,enabled=true,dataProvider = "testData", dataProviderClass = DataProviderUtil.class)
	public void createUserTest(UserPOJO payload) {
		Response response = UserEndPointsUsingPropertiesFile.createUser(payload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority=2,dataProvider="userData",dataProviderClass = DataProviderUtil.class)
	public void getUserTest(String username) {
		Response response = UserEndPointsUsingPropertiesFile.getUser(username);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	
	@Test(priority=3,dataProvider="userData",dataProviderClass = DataProviderUtil.class)
	public void deleteUserTest(String username) {	
		Response response = UserEndPointsUsingPropertiesFile.deleteUser(username);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority=4,dataProvider="userData",dataProviderClass = DataProviderUtil.class)
	public void getUserAfterDelete(String username) {	
		Response response = UserEndPointsUsingPropertiesFile.getUser(username);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 404);
	}
	
}
