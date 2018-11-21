package com.capg.paymentwallet.ui;

import java.math.BigInteger;
import java.util.List;
import java.util.Scanner;

import com.capg.paymentwallet.bean.CustomerBean;
import com.capg.paymentwallet.exception.CustomerException;
import com.capg.paymentwallet.service.CustomerServiceImpl;
import com.capg.paymentwallet.service.ICustomerService;

public class Client {
	   
	ICustomerService service=new CustomerServiceImpl();
	CustomerBean customer=new CustomerBean();
	Scanner scanner=new Scanner(System.in);
	public static void main(String[] args) throws Exception {
		char ch;
		Client client=new  Client();
		do
		{
		System.out.println("========Payment wallet application========");
		System.out.println("1. Create Account ");
		System.out.println("2. Show Balance ");
		System.out.println("3. Deposit ");
		System.out.println("4. Withdraw ");
		System.out.println("5. Fund Transfer");
		System.out.println("6. Print Transactions");
		System.out.println("7. Exit");
		System.out.println("Choose an option");
		int option =client. scanner.nextInt();
		
		switch (option) {
		case 1:client.create();
               break;
		case 2:client.showbalance();

			break;

		case 3:client.deposit();

			break;
			
			
		case 4:client.withdraw();

			break;
			
			/*
		case 5:client.fundtransfer();

			break;
		case 6:client.printTransaction();

			break;
		case 7:System.exit(0);

			break;
*/
		default:System.out.println("invalid option");
			break;
		}
		
		System.out.println("Do you want to continue press Y/N");
		ch=client.scanner.next().charAt(0);
		
		}while(ch=='y' || ch=='Y');

		
	}
	
	
	void create() throws CustomerException
	{
		
		System.out.println("Enter your firstname");
		String fname=scanner.next();
		
		System.out.println("Enter your lastname");
		String lname=scanner.next();
		
		System.out.println("Enter your email id");
		String email=scanner.next();
		
		System.out.println("Enter your phone number");
		BigInteger phone=scanner.nextBigInteger();
		
		System.out.println("Enter your pan number");
		String pan=scanner.next();
		
		System.out.println("Enter your address");
		String address=scanner.next();
		
		System.out.println("Enter balance to create account");
		double balance=scanner.nextDouble();

		customer.setEmailId(email);
		customer.setFirstName(fname);
		customer.setLastName(lname);
		customer.setAddress(address);
		customer.setPhoneNo(phone);
		customer.setPanNum(pan);
		customer.setBalance(balance);
		
		boolean result=service.createAccount(customer);
		
		if(result)
		{
			System.out.println("Congratulations your account has been created successfully...");
		}
		else
		{
			System.out.println("Enter valid details..");
		}
	}
	
	
	void showbalance() throws CustomerException, Exception 
	{
		System.out.println("Enter your phone number");
		BigInteger phno=scanner.nextBigInteger();
		double balance=service.showBalance(phno);
		System.out.println(balance);
		if(balance>0)
		{
		System.out.println("Your balance is: " +balance);
		}
		else
		{
			System.out.println("Enter valid phone number");
		}
			
		
	}
	
	void deposit() throws CustomerException
	{
		System.out.println("Enter phone number");
		BigInteger phone=scanner.nextBigInteger();
		System.out.println("Enter amount that you want to deposit");
		double depositAmt=scanner.nextDouble();
		double balance=service.deposit(phone, depositAmt);
		if(balance>0)
		{
			System.out.println("balance after deposit.."+balance);
		}
		else
		{
			System.out.println("Enter valid phone number");
		}
	}
	
	void withdraw() throws CustomerException
	{
		System.out.println("Enter phone number");
		BigInteger phone=scanner.nextBigInteger();
		System.out.println("Enter amount that you want to withdraw");
		double drawAmt=scanner.nextDouble();
		double balance=service.withdraw(phone, drawAmt);
		if(balance>0)
		{
			System.out.println("balance after withdraw.."+balance);
		}
		else
		{
			System.out.println("Enter valid phone number");
		}
		
	}
	
	/*void fundtransfer()
	{
		System.out.println("Enter phone number");
		BigInteger phone=scanner.nextBigInteger();
		System.out.println("Enter amount that you want to transfer");
		double amt=scanner.nextDouble();
		System.out.println("Enter another phone number ");
		BigInteger phone1=scanner.nextBigInteger();
		double balance=service.fundTransfer(phone, amt, phone1);
	
	if(balance>0)
	{
		System.out.println("balance after transfer.."+balance);
	}
	else
	{
		System.out.println("Enter valid phone number");
	}
	}
	
	void printTransaction()
	{
		List<String> list=service.printTransaction();
		if(list.size()>0)
		{
			System.out.println(list);
		}
		else
		{
			System.out.println("No transactions are available");
		}
	}
	*/
	    
	
}
