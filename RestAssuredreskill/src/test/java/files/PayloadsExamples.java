package files;

public class PayloadsExamples {

	public static String addPlaceJson() {
		return "{\r\n" + "    \"location\": {\r\n" + "        \"lat\": -58.383494,\r\n"
				+ "        \"lng\": 63.427362\r\n" + "    },\r\n" + "    \"accuracy\": 50,\r\n"
				+ "    \"name\": \"Arihant Niwas \",\r\n" + "    \"phone_number\": \"(+91) 8999552006\",\r\n"
				+ "    \"address\": \"Near Old balaji temple\",\r\n" + "    \"types\": [\r\n" + "        \"home\",\r\n"
				+ "        \"shop\"\r\n" + "    ],\r\n" + "    \"website\": \"http://google.com\",\r\n"
				+ "    \"language\": \"French-IN\"\r\n" + "}";

	}
	
	public static String updatePlace(String placeID) {
		return "{\r\n"
				+ "    \"place_id\": \" " + placeID +" \",\r\n"
				+ "    \"address\": \"70 Summer walk,USA\",\r\n"
				+ "    \"key\": \"qaclick123\"\r\n"
				+ "}";
	}
	
	public static String coursePrize() {
		
		return "{\r\n"
				+ "  \"dashboard\": {\r\n"
				+ "    \"purchaseAmount\": 910,\r\n"
				+ "    \"website\": \"rahulshettyacademy.com\"\r\n"
				+ "  },\r\n"
				+ "  \"courses\": [\r\n"
				+ "    {\r\n"
				+ "      \"title\": \"Selenium Python\",\r\n"
				+ "      \"price\": 50,\r\n"
				+ "      \"copies\": 6\r\n"
				+ "    },\r\n"
				+ "    {\r\n"
				+ "      \"title\": \"Cypress\",\r\n"
				+ "      \"price\": 40,\r\n"
				+ "      \"copies\": 4\r\n"
				+ "    },\r\n"
				+ "    {\r\n"
				+ "      \"title\": \"RPA\",\r\n"
				+ "      \"price\": 45,\r\n"
				+ "      \"copies\": 10\r\n"
				+ "    }\r\n"
				+ "  ]\r\n"
				+ "}";
		
	}
}
