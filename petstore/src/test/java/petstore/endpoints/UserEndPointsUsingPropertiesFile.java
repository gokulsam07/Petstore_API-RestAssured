package petstore.endpoints;

import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import petstore.payloads.UserPOJO;

public class UserEndPointsUsingPropertiesFile {

	private static ResourceBundle loadURL() {
		ResourceBundle url = ResourceBundle.getBundle("routes"); //Loading properties file
		return url;
	}

	public static Response createUser(UserPOJO payload){
		String create = loadURL().getString("createUser");
		Response response = 	given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
				.when()
				.post(create);
		return response;
	}

	public static Response getUser(String userName){
		String get = loadURL().getString("getUser");
		Response response = 	given()
				.pathParam("username", userName)
				.when()
				.get(get);
		return response;
	}

	public static Response updateUser(UserPOJO payload, String userName){
		String update = loadURL().getString("updateUser");
		Response response = 	given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
				.pathParam("username", userName)
				.when()
				.put(update);
		return response;
	}

	public static Response deleteUser(String userName){
		String delete = loadURL().getString("deleteUser");
		Response response = 	given()
				.pathParam("username", userName)
				.when()
				.delete(delete);
		return response;
	}
}
