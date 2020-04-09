package com.banking;

public class Application {

	/**
	 * @param args
	 * This is the starting point of our Banking Application
	 */
	public static void main(String[] args) {
		Account obj = new Account("Dhananjay Rout", "5648");
		obj.showMenu();
		System.out.println("Application Process Over.");
	}

}
