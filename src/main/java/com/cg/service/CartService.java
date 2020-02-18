package com.cg.service;

import java.util.List;

import com.cg.dto.Product;
import com.cg.exception.CartIdNotFoundException;
import com.cg.exception.ProductNotFoundException;
import com.cg.exception.ValidateException;

public interface CartService {
	boolean addToCart(String cartId, String productId) throws ProductNotFoundException, ValidateException;

	List<Product> viewCart(String cartId) throws CartIdNotFoundException;

}
