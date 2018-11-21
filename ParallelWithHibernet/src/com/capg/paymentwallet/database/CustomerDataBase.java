package com.capg.paymentwallet.database;

import java.math.BigInteger;
import java.util.ArrayList;

import com.capg.paymentwallet.bean.CustomerBean;

public class CustomerDataBase {

	private static ArrayList<CustomerBean> list = new ArrayList<CustomerBean>();

	private static ArrayList<String> printList = new ArrayList<String>();

	static {
		CustomerBean customerbean = new CustomerBean();
		customerbean.setFirstName("sandhya");
		customerbean.setLastName("gadi");
		customerbean.setEmailId("abcdef@gmail.com");
		customerbean.setPhoneNo(new BigInteger("8465033260"));
		customerbean.setPanNum("CTP103P96T");
		customerbean.setBalance(2000.0);
		customerbean.setAddress("HYDEERABAD");
		list.add(customerbean);
		CustomerBean customerbean1 = new CustomerBean();
		customerbean1.setFirstName("sumanvitha");
		customerbean1.setLastName("dhurjati");
		customerbean1.setEmailId("suma@gmail.com");
		customerbean1.setPhoneNo(new BigInteger("9989090808"));
		customerbean1.setPanNum("BDFGW12309");
		customerbean1.setBalance(1000.0);
		customerbean1.setAddress("CHENNAI");
		list.add(customerbean1);
	}

	public static ArrayList<CustomerBean> getCustomerList() {
		return list;
	}
	public static ArrayList<String> getCustomerListToPrint() {
		return printList;
	}

}
