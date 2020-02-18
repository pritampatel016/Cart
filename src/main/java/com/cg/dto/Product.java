package com.cg.dto;

public class Product {
	private String productId;
	private String productName;
	private String productInfo;
	private String brandName;
	private double price;

	public Product(String productId, String productName, String productInfo, String brandName, double price) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productInfo = productInfo;
		this.brandName = brandName;
		this.price = price;
	}

	public String getProductId() {
		return productId;
	}

	public String getProductName() {
		return productName;
	}

	public String getProductInfo() {
		return productInfo;
	}

	public String getBrandName() {
		return brandName;
	}

	public double getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "productId=" + productId + ", productName=" + productName + ", productInfo=" + productInfo
				+ ", brandName=" + brandName + ", price=" + price;
	}

}
