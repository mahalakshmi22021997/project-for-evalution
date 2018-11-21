package com.capg.paymentwallet.dao;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import com.capg.paymentwallet.bean.CustomerBean;
import com.capg.paymentwallet.exception.CustomerException;

public interface ICustomerDao {


    public boolean createAccount(CustomerBean customerbean) throws CustomerException ;
    public double showBalance(BigInteger phoneNo) ;
    public double deposit(BigInteger phoneNo,double rupees) ;
    public double withdraw(BigInteger phoneNo, double rupees) ;
    public double fundTransfer(BigInteger phoneNo,double balance,BigInteger anotherPhnNum);
    public ArrayList<String> addTransaction(double amount,String msg,LocalDate date,LocalTime time);
    public ArrayList<String> printTransaction();
	
	 
    
}
