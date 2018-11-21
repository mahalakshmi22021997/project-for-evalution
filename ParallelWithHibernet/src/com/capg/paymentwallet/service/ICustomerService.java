package com.capg.paymentwallet.service;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import com.capg.paymentwallet.bean.CustomerBean;
import com.capg.paymentwallet.exception.CustomerException;

public interface ICustomerService {

          public boolean createAccount(CustomerBean customerbean) throws CustomerException ;
          public double showBalance(BigInteger phoneNo) throws CustomerException, Exception ;
          public double deposit(BigInteger phoneNo,double rupees) throws CustomerException ;
          public double withdraw(BigInteger phoneNo, double rupees) throws CustomerException;
          public double fundTransfer(BigInteger phoneNo,double balance,BigInteger anotherPhnNum) ;
          public ArrayList<String> addTransaction(double amount,String msg,LocalDate date,LocalTime time);
          public ArrayList<String> printTransaction();
		 
          
	
}
