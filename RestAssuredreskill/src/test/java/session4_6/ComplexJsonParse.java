package session4_6;

import org.testng.Assert;

import files.PayloadsExamples;
import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JsonPath js1 = new JsonPath(PayloadsExamples.coursePrize());

		int coursesCount = js1.getInt("courses.size()");

		System.out.println(" no . of courses : " + coursesCount);

		// --------Print Purchase Amount-----

		int sum = 0;
		for (int i = 0; i < coursesCount; i++) {

			int price = js1.getInt("courses[" + i + "].price");
			int copies = js1.getInt("courses[" + i + "].copies");
			sum = sum + (price * copies);
		}

		System.out.println("Total Purchase Amount : " + sum);

		// Verify if Sum of all Course prices matches with Purchase Amount

		int expectedTotalPrice = js1.getInt("dashboard.purchaseAmount");

		// assert that expected total and actual total is same
		Assert.assertEquals(sum, expectedTotalPrice, "Miss calculation in Total Purchase amount. ");

		// ----Print Title of the first course--------
		String firstCourse = js1.getString("courses[0].title");
		System.out.println("Title of first course is : " + firstCourse);

		// -------Print All course titles and their respective Prices-------
		for (int i = 0; i < coursesCount; i++) {

			String title = js1.getString("courses[" + i + "].title");
			int price = js1.getInt("courses[" + i + "].price");
			System.out.println("title : " + title + " ||  " + "price :" + price);

		}

	}

}
