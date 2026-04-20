package session4_6;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import files.PayloadsExamples;
import static org.hamcrest.Matchers.*;

public class DemoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// add place --> update place with new address --> get place to validate if new
		// address is present in response

		RestAssured.baseURI = "https://rahulshettyacademy.com";

		String response = given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
				.body(PayloadsExamples.addPlaceJson()).when().post("maps/api/place/add/json").then().log().all()
				.assertThat().statusCode(200).body("scope", equalTo("APP")).header("server", "Apache/2.4.52 (Ubuntu)")
				.extract().response().asString();

		JsonPath js = new JsonPath(response);
		String placeId = js.getString("place_id");
		System.out.println("=========>" + placeId);

		// update place

		given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
				.body(PayloadsExamples.updatePlace(placeId)).when().put("/maps/api/place/update/json").then()
				.assertThat().statusCode(200).body("msg", equalTo("Address successfully updated"));

		// get address

		String getPlaceResponse = given().log().all().queryParam("place_id", placeId).queryParam("key", "qaclick123").when()
				.get("maps/api/place/get/json").then().assertThat().log().all().statusCode(200).extract().response().asString();
		
		JsonPath js1 = new JsonPath(getPlaceResponse);
		

	}

}
