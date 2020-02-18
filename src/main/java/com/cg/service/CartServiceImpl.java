package com.cg.service;

import java.util.ArrayList;
import java.util.List;

import com.cg.dao.CartDao;
import com.cg.dao.CartDaoImpl;
import com.cg.dto.Cart;
import com.cg.dto.Product;
import com.cg.exception.CartIdNotFoundException;
import com.cg.exception.ProductNotFoundException;
import com.cg.exception.ValidateException;
import com.cg.repo.CgRepo;

public class CartServiceImpl implements CartService {

	CartDao dao = new CartDaoImpl();

	@Override
	public boolean addToCart(String cartId, String productId) throws ProductNotFoundException, ValidateException {
		if (!productId.matches("[1-9][0-9]{3}"))
			throw new ValidateException("productID must contain 4 digits and first digit must be 1-9");
		boolean addCheck = false;
		Product product = dao.getProduct(productId);

		Cart cart = dao.getCart(cartId);
		if (cart != null) {
			List<Product> pList = cart.getProducts();
			pList.add(product);
			cart.setProducts(pList);
			addCheck = dao.setCart(cart);
		} else {
			String id = String.valueOf(++CgRepo.cartId);
			List<Product> list = new ArrayList<>();
			list.add(product);
			Cart newCart = new Cart(id, list);
			addCheck = dao.setCart(newCart);
		}

		return addCheck;
	}

	@Override
	public List<Product> viewCart(String cartId) throws CartIdNotFoundException {
		Cart cart = dao.getCart(cartId);
		if (cart == null)
			throw new CartIdNotFoundException("cart id not found");
		List<Product> list = cart.getProducts();

		return list;
	}

}
