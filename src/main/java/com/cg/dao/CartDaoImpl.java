package com.cg.dao;

import java.util.Map;

import com.cg.dto.Cart;
import com.cg.dto.Product;
import com.cg.exception.ProductNotFoundException;
import com.cg.repo.CgRepo;

public class CartDaoImpl implements CartDao {

	private Map<String, Cart> cartMap = CgRepo.cartMap;
	private Map<String, Product> productMap = CgRepo.map;

	@Override
	public Product getProduct(String productId) throws ProductNotFoundException {

		/*
		 * AutherName:-PritamPatel Description:- This method checks if the productId is
		 * available in the productMap as a key and returns the value stored in the
		 * productMap for that particular key. If ProductId is not available in the
		 * ProductMap then it throws ProductNotAvailable exception.
		 * 
		 * Parameter:- productId (String) Return Type:- Product
		 */

		if (!productMap.containsKey(productId))
			throw new ProductNotFoundException("product not available");
		Product product = productMap.get(productId);
		return product;
	}

	@Override
	public Cart getCart(String cartId) {

		/*
		 * AutherName:-PritamPatel Description:- This method checks if the cartId is
		 * available in the cartMap as a key and returns the value stored in the cartMap
		 * for that particular key.It returns null if the key is not available.
		 * 
		 * Parameter:- cartId (String) Return Type:- Cart
		 */

		Cart cart = cartMap.get(cartId);
		return cart;
	}

	@Override
	public boolean setCart(Cart cart) {
		/*
		 * AutherName:-PritamPatel Description:- This method checks if the productId is
		 * available in the productMap as a key and returns the value stored in the
		 * productMap for that particular key. If ProductId is not available in the
		 * ProductMap then it throws ProductNotAvailable exception.
		 * 
		 * Parameter:- productId (String) Return Type:- Product
		 */
		Cart cart1 = cartMap.put(cart.getCartId(), cart);
		// return true;
		if (cart1 != null)
			return true;
		return false;
	}

}
