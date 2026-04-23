package e2eAPItest;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateOrderResponseJson {

	private List<String> orders;
	private List<String> productOrderId;
	private String message;

	// Default constructor (required for Jackson)
	public CreateOrderResponseJson() {
	}

	// Getters and Setters

	public List<String> getOrders() {
		return orders;
	}

	public void setOrders(List<String> orders) {
		this.orders = orders;
	}

	public List<String> getProductOrderId() {
		return productOrderId;
	}

	public void setProductOrderId(List<String> productOrderId) {
		this.productOrderId = productOrderId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
