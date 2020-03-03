package com.banking;
import java.util.Scanner;

public class Account {
	String customerName;
	String customerId;
	int balance;
	int previousTransaction;
	
	//constructor
	Account(String cName, String cId) {
		customerName = cName;
		customerId = cId;
	}
	//methods
	
	/**
	 * @param amount
	 * This method adds the amount to the remaining balance
	 */
	public void deposit(int amount) {
		if(amount<=0) {
			System.out.println("Invalid amount. Please enter a valid amount.");
			return;
		}
		else {
			balance+=amount;
			previousTransaction=amount;
		}
	}
	
	/**
	 * @param amount
	 * This method subtracts the amount from the remaining balance
	 * It also checks if the amount mentioned is smaller than the balance or not
	 */
	public void withdraw(int amount) {
		if(amount<=0) {
			System.out.println("Invalid amount. Please enter a valid amount.");
			return;
		}
		else if(amount>balance) {
			System.out.println("You do not have sufficient fund in your account.");
			return;
		}
		else {
			balance-=amount;
			previousTransaction=-amount;
		}
	}
	
	/**
	 * This method displays the remaining balance
	 */
	public void checkBalance() {
		System.out.println("Balance = "+balance);
	}
	
	/**
	 * This method just shows the last transaction report
	 */
	public void showPreviousTransaction() {
		if(previousTransaction<0) {
			System.out.println("Withdraw : "+Math.abs(previousTransaction));
			
		}
		else if(previousTransaction>0){
			System.out.println("Deposit : "+previousTransaction);
		}
		else {
			System.out.println("No previous transaction found!");
		}
	}
	/**
	 * This method displays all the options to choose
	 */
	public void showMenu() {
		System.out.println("Hi "+customerName + ", Welcome to Online Banking!");
		System.out.println("Your customer Id is : "+customerId);
		System.out.println();
		int option=0;
		
		do {
			System.out.println("Choose an option.");
			System.out.println("1 - Check Balance");
			System.out.println("2 - Deposit");
			System.out.println("3 - Withdraw");
			System.out.println("4 - Check Previous Transaction");
			System.out.println("5 - Exit");
			
			Scanner sc = new Scanner(System.in);
			option = sc.nextInt();
			
			switch(option) {
			case 1:
				checkBalance();
				break;
			case 2:
				System.out.println("Enter the amount to be deposited.");
				int amount = sc.nextInt();
				deposit(amount);
				break;
			case 3:
				System.out.println("Enter the amount to be withdrawn.");
				amount = sc.nextInt();
				withdraw(amount);
				break;
			case 4:
				showPreviousTransaction();
				break;
			case 5:
				System.out.println("Exiting the application..");
				break;
			default:
				System.out.println("Invalid option. Please enter a valid option.");
			}
		}while(option!=5);
		
		System.out.println("Thank you for using our service!");
		
	}
	
	

}
