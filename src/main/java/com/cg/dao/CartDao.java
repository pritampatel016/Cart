package com.cg.dao;

import com.cg.dto.Cart;
import com.cg.dto.Product;
import com.cg.exception.ProductNotFoundException;

public interface CartDao {

	Product getProduct(String productId) throws ProductNotFoundException;

	Cart getCart(String cartId);

	boolean setCart(Cart cart);

}
