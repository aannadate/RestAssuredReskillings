package session_10_11;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.* ;

public class MapClassApiTest {
  @Test
  public void addPlace() {
	  
	  AddPlacePOJO obj = new AddPlacePOJO();
	  Location loc = new Location();
	  List<String> types = new ArrayList<>();
	  types.add("home");
	  types.add("office");
	  
	  loc.setLat(23.534);
	  loc.setLng(38.534);
	  
	  obj.setAccuracy(50);
	  obj.setAddress("near old balaji temple");
	  obj.setLanguage("Marathi");
	  obj.setLocation(loc);
	  obj.setName("aniket");
	  obj.setPhone_number("9564857215");
	  obj.setTypes(types);
	  obj.setWebsite("www.cox.com");
	  
	  //---------------------------------
	  
	  RestAssured.baseURI = "https://rahulshettyacademy.com/";
	  
	  given()
	  .body(obj)
	  .when()
	  .queryParam("key", "qaclick123")
	  .post("/maps/api/place/add/json")
	  .then().statusCode(200);
	  
	  
  }
}
