package petstore.endpoints;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import petstore.payloads.UserPOJO;

public class UserEndPoints {

	public static Response createUser(UserPOJO payload){
		Response response = 	given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
				.when()
				.post(Routes.createUser);
		return response;
	}

	public static Response getUser(String userName){
		Response response = 	given()
				.pathParam("username", userName)
				.when()
				.get(Routes.getUser);
		return response;
	}

	public static Response updateUser(UserPOJO payload, String userName){
		Response response = 	given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
				.pathParam("username", userName)
				.when()
				.put(Routes.updateUser);
		return response;
	}
	
	public static Response deleteUser(String userName){
		Response response = 	given()
				.pathParam("username", userName)
				.when()
				.delete(Routes.deleteUser);
		return response;
	}

}
