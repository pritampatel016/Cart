package com.cg.service;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.cg.exception.CartIdNotFoundException;

public class TestViewCart {

	private static CartService ser;

	@BeforeAll
	public static void beforeAll() {
		ser = new CartServiceImpl();
	}

	@Test
	public void test1() {
		assertThrows(CartIdNotFoundException.class, () -> ser.viewCart("100"));
	}

}
