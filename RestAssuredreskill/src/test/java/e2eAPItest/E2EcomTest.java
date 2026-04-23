package e2eAPItest;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;


public class E2EcomTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		RequestSpecification resSpec = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").setContentType(ContentType.JSON).build();
		
		String loginPayload = "C:\\Users\\HP\\git\\RestAssuredReskillings\\RestAssuredreskill\\src\\test\\java\\e2eAPItest\\loginPayload.json";
		
		LoginPojo loginBody = new LoginPojo();
		loginBody.setUserEmail("annadateaniket@gmail.com");
		loginBody.setUserPassword("Pass#2026");
		
		RequestSpecification reqLogin = given().spec(resSpec).body(loginBody);
		
		LoginResponseJson loginResp =  reqLogin.when().post("/api/ecom/auth/login").then().extract().response().as(LoginResponseJson.class);
		
		String authToken = loginResp.getToken();
		String userId = loginResp.getUserId();
		
		System.out.println(userId);
		
		//Add Product to site 
		
		RequestSpecification resSpec_addProduct = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.addHeader("Authorization", authToken)
				.build();
		
		RequestSpecification reqAddProduct = given().spec(resSpec_addProduct).param("productName", "HpLaptop 123")
		.param("productAddedBy", userId)
		.param("productCategory", "Fashion")
		.param("productSubCategory", "Shirts")
		.param("productPrice","299")
		.param("productDescription", "Addias Originals")
		.param("productFor", "women")
		.multiPart("productImage",new File("A:\\dels\\images.png"));
		
		AddProductResponseJson res =  reqAddProduct.when().post("/api/ecom/product/add-product").then().extract().response().as(AddProductResponseJson.class);
		
		String productId = res.getProductId();
		
		// place the order 
		
		RequestSpecification resSpec_CreateOrder = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.addHeader("Authorization", authToken).setContentType(ContentType.JSON).build();
		
		CreateOrderRequestJson_orders  obj1 = new CreateOrderRequestJson_orders();
		CreateOrderRequestJson_orderDetails od1 = new CreateOrderRequestJson_orderDetails();
		
		od1.setCountry("Indian");
		od1.setProductOrderedId(productId);
		
		List<CreateOrderRequestJson_orderDetails> list = new ArrayList<>();
		list.add(od1);
		
		obj1.setOrders(list);
		
		CreateOrderResponseJson orderCreated = given().log().all().spec(resSpec_CreateOrder).body(obj1)
		.when().post("/api/ecom/order/create-order").then().extract().response().as(CreateOrderResponseJson.class);
		
		
		Assert.assertEquals(orderCreated.getMessage(), "Order Placed Successfully","order created failed");
		
		
		// Delete the Product 
		RequestSpecification resSpec_deleteProduct = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.addHeader("Authorization", authToken).build();
		
		 given().log().all().spec(resSpec_deleteProduct).pathParam("productId", productId).when().delete("/api/ecom/product/delete-product/{productId}")
		.then().log().all().extract().response().asString();
		
		
	}

}
