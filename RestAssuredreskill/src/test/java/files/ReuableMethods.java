package files;

import io.restassured.path.json.JsonPath;

public class ReuableMethods {

	public static JsonPath rawToJson(String res) {
		JsonPath js1 = new JsonPath(res);
		return js1;
	}
}
