package com.capg.paymentwallet.bean;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalTime;

public class FundTransferBean {
	
	
	private LocalDate date;
	private LocalTime time;
	private BigInteger phoneNum;
	private double fundtransferAmt;
	private BigInteger anotherPhnNum;

	
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
	public double getFundtransferAmt() {
		return fundtransferAmt;
	}
	public void setFundtransferAmt(double fundtransferAmt) {
		this.fundtransferAmt = fundtransferAmt;
	}
	public BigInteger getanotherPhnNum() {
		return anotherPhnNum;
	}
	public void setaPhnNum(BigInteger anotherPhnNum) {
		this.anotherPhnNum = anotherPhnNum;
	}
	
}
