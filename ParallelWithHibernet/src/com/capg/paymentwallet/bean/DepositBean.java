package com.capg.paymentwallet.bean;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalTime;

public class DepositBean {
	
	private LocalDate date;
	private LocalTime time;
	private BigInteger phoneNum;
	private double depositAmt;
	private double balance;
	
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public LocalTime getTime() {
		return time;
	}
	public void setTime(LocalTime time) {
		this.time = time;
	}
	public BigInteger getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(BigInteger phoneNum) {
		this.phoneNum = phoneNum;
	}
	public double getDepositAmt() {
		return depositAmt;
	}
	public void setDepositAmt(double depositAmt) {
		this.depositAmt = depositAmt;
	}
	
	

}
