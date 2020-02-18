package com.cg.ui;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		String str = null;
		do {
			displayMenu();
			System.out.println("please enter your choice");
			showData(scan.nextInt());
			System.out.println("enter 'y' to continue");
			str = scan.next();
		} while (str.equals("y"));
	}

	public static void displayMenu() {
		System.out.println("----------------------------WEL COME------------------------");
		System.out.println("");
		System.out.println("");
		System.out.println("Press '1' to add to the cart");
		System.out.println("*****************************");
		System.out.println("Press '2'view from the cart");
		System.out.println("");
	}

	public static void showData(int choice) {
		UiClient obj = new UiClient();
		switch (choice) {
		case 1:
			obj.add();
			break;
		case 2:
			obj.viewCart();
			break;

		default:
			System.out.println("please enter valid option");

		}
	}

}
