package petstore.endpoints;

public class Routes {
	public static String baseURI = "https://petstore.swagger.io/v2";

	//User Module Routes

	public static String createUser = baseURI+"/user";
	public static String getUser = baseURI+"/user/{username}";
	public static String updateUser = baseURI+"/user/{username}";
	public static String deleteUser = baseURI+"/user/{username}";
}
