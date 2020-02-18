package com.cg.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.cg.exception.ProductNotFoundException;
import com.cg.exception.ValidateException;

public class TestAddToCart {

	CartService ser = new CartServiceImpl();

	@Test
	public void test1() throws ProductNotFoundException, ValidateException {

		assertTrue(ser.addToCart("102", "1102"));
	}

	@Test
	public void test2() throws ProductNotFoundException, ValidateException {

		assertTrue(ser.addToCart("101", "1103"));
	}

	@Test
	public void test3() throws ProductNotFoundException, ValidateException {

		assertFalse(ser.addToCart("11", "1103"));
	}

	@Test
	public void test4() {
		assertThrows(ProductNotFoundException.class, () -> ser.addToCart("111", "1108"));
	}

	@Test
	public void test5() {
		assertThrows(ValidateException.class, () -> ser.addToCart("101", "21371"));
	}

}
