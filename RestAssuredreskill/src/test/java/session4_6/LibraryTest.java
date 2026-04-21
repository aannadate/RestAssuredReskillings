package session4_6;

import org.testng.annotations.Test;

import files.PayloadsExamples;
import files.Reusable;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

public class LibraryTest {

	String id;

	@Test(dataProvider="BookData")
	public void addBook(String isbn, String aisle) {

		String response = given().contentType("application/json").body(PayloadsExamples.addBookPayload(isbn,aisle))
				.when().post("/Library/Addbook.php").then().extract().asString();

		System.out.println(response);
		JsonPath js1 = Reusable.rawToJson(response);
		id = js1.getString("ID");

		System.out.println(id);

	}

	@BeforeMethod
	public void beforeMethod() {
		RestAssured.baseURI = "http://216.10.245.166";
		System.out.println("Before Method...");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("Before Test...");
	}

	@DataProvider(name = "BookData")
	public Object[][] getBookData() {
		// array == collection of data
		// multi-dimensional array == collection of array

		return new Object[][] { { "ISN", "1173" }, { "JSA", "7832" }, { "ANC", "9822" } };

	}

}
