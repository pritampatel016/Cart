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

	/**
	 * @author Pritam Patel
	 * 
	 *         Description:-This method checks the validation for the productId
	 *         where it should contain 4 digits and first digit cannot be zero if
	 *         the productId do not matches the condition then it throws
	 *         validateException. The value stored in the particular cartId and
	 *         productId are stored. if the value stored in the cart is not null
	 *         then the product is added to the list and finally it is added in the
	 *         cartMap. and if the cart is null then a new cartId is created and the
	 *         product is added in the cartMap.
	 *
	 *         Parametrs:cartId (String), productId (String) Return type:-boolean
	 * @throws ProductAlreadyExistsException
	 * 
	 */
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
			List<Product> lst = new ArrayList<>();
			lst.add(product);
			Cart newCart = new Cart(id, lst);
			addCheck = dao.setCart(newCart);
		}

		return addCheck;
	}

	/**
	 * @author Pritam Patel
	 * 
	 *         Description:-This method is used to view the contents of the cart for
	 *         a particular cartId. if the cartId is not found then it throws
	 *         CartIdNotFoundException.
	 * 
	 *         Parameter: cartId(String) Return type:- List<Product>
	 * 
	 */
	@Override
	public List<Product> viewCart(String cartId) throws CartIdNotFoundException {
		Cart cart = dao.getCart(cartId);
		if (cart == null)
			throw new CartIdNotFoundException("cart id not found");
		List<Product> list = cart.getProducts();

		return list;
	}

}
