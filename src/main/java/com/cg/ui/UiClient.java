package com.cg.ui;

import java.util.List;
import java.util.Scanner;

import com.cg.dto.Product;
import com.cg.exception.CartIdNotFoundException;
import com.cg.exception.ProductNotFoundException;
import com.cg.exception.ValidateException;
import com.cg.service.CartService;
import com.cg.service.CartServiceImpl;

public class UiClient {
	Scanner scan = new Scanner(System.in);
	CartService obj = new CartServiceImpl();

	public void add() {
		System.out.println("enter the cart id");
		String cartId = scan.next();
		try {
			System.out.println("enter the product id");
			String pid = scan.next();

			boolean res = obj.addToCart(cartId, pid);
			if (res)
				System.out.println("item added to the cart successfully");
			System.out.println(" ");
			System.out.println("===========================================================");

		} catch (ValidateException | ProductNotFoundException e) {
			System.err.println(e.getMessage());
		}

	}

	public void viewCart() {
		System.out.println("enter the cartid");
		try {
			String cartId = scan.next();
			List<Product> list = obj.viewCart(cartId);
			for (Product prod : list) {
				System.out.println(prod);
			}

		} catch (CartIdNotFoundException e) {
			System.err.println(e.getMessage());
		}
	}

}
