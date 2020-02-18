package com.cg.repo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.cg.dto.Cart;
import com.cg.dto.Product;

public class CgRepo {

	public static int cartId = 0;
	public static Map<String, Product> map = new HashMap<>();
	public static Map<String, Cart> cartMap = new LinkedHashMap<>();

	static {
		/*--------------------------------Product Data----------------------------------------*/
		// Creating the instance of Product class and passing the values as parameters
		// The parameters are productId,ProductName,productInfo,brands,price

		Product p1 = new Product("1100", "shoes", "formal shoes", " Bata", 1200.0);
		Product p2 = new Product("1101", "Mobile", "Samsung Galaxy A50 ( 64 GB)(4 GB RAM)", "Samsung", 18000.0);
		Product p3 = new Product("1102", "Shirt", "Sports Wear", " puma", 6500.0);
		Product p4 = new Product("1103", "T-Shirt", "Solid Men Polo Neck Dark Blue T-Shirt", "Peter-England", 1200.0);

		// passing the instance of product class into the map as values

		map.put("1100", p1);
		map.put("1101", p2);
		map.put("1102", p3);
		map.put("1103", p4);

		List<Product> plist = new ArrayList<>();
		plist.add(p4);

		// creating the instance of Cart class and passing into the cartMap as values
		// The parameters are cartId,products
		Cart c1 = new Cart("101", plist);
		Cart c2 = new Cart("102", plist);
		cartMap.put("101", c1);
		cartMap.put("102", c2);
	}

}
