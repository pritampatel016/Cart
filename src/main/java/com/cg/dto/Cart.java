package com.cg.dto;

import java.util.List;

public class Cart {
	private String cartId;
	private List<Product> products;

	public Cart(String cartId, List<Product> products) {
		super();
		this.cartId = cartId;
		this.products = products;
	}

	public String getCartId() {
		return cartId;
	}

	public void setCartId(String cartId) {
		this.cartId = cartId;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", products=" + products + "]";
	}

}
