package com.capg.paymentwallet.service;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import com.capg.paymentwallet.bean.CustomerBean;
import com.capg.paymentwallet.bean.DepositBean;
import com.capg.paymentwallet.dao.CustomerDaoImpl;
import com.capg.paymentwallet.dao.ICustomerDao;
import com.capg.paymentwallet.exception.CustomerException;
import com.capg.paymentwallet.exception.CustomerExceptionMessage;

public class CustomerServiceImpl implements ICustomerService {
	ICustomerDao dao = new CustomerDaoImpl();
	CustomerBean customerbean = new CustomerBean();
	double balance;

	@Override
	public boolean createAccount(CustomerBean customerbean)
			throws CustomerException {
		// TODO Auto-generated method stub
		boolean result = validateCustomer(customerbean);
		if (result) {
			return dao.createAccount(customerbean);
		} else {
			return false;
		}
	}

	@Override
	public double showBalance(BigInteger phoneNo) throws Exception {
		// TODO Auto-generated method stub
		// double balance=0.0;
		boolean result = validateShowBalance(phoneNo);
		if (result) {
			balance = dao.showBalance(phoneNo);
			return balance;
		} else {
			// System.out.println("invalid");
			return balance;
		}
	}

	@Override
	public double deposit(BigInteger phoneNo, double rupees)
			throws CustomerException {
		// TODO Auto-generated method stub

		boolean result = validateDeposit(rupees, phoneNo);
		// System.out.println("result is "+result);
		if (result) {
			balance = dao.deposit(phoneNo, rupees);
			return balance;

		} else {
			// System.out.println("invalid");
			return balance;
		}
	}

	@Override
	public double withdraw(BigInteger phoneNo, double rupees)
			throws CustomerException {

		boolean result = validateWithdraw(rupees, phoneNo);
		if (result) {
			balance = dao.deposit(phoneNo, rupees);
			return balance;

		} else {
			// System.out.println("invalid");
			return balance;
		}
	}

	@Override
	public double fundTransfer(BigInteger phoneNo, double balance,
			BigInteger phnum) {

		// validateFundTransfer(balance, phnum);
		return dao.fundTransfer(phoneNo, balance, phnum);
	}

	@Override
	public ArrayList<String> addTransaction(double amount, String msg,
			LocalDate date, LocalTime time) {
		// TODO Auto-generated method stub
		return dao.addTransaction(amount, msg, date, time);
	}

	@Override
	public ArrayList<String> printTransaction() {
		// TODO Auto-generated method stub

		return dao.printTransaction();
	}

	public boolean validateCustomer(CustomerBean customer)
			throws CustomerException {
		boolean isValid = true;

		if (!(customer.getFirstName().matches("[a-zA-Z]{3,}"))) {
			// isValid=false;
			throw new CustomerException(CustomerExceptionMessage.ERROR1);
		}
		if (!(customer.getLastName().matches("[a-zA-Z]{3,}"))) {
			// isValid=false;
			throw new CustomerException(CustomerExceptionMessage.ERROR2);
		}
		if (!(customer.getPhoneNo().toString().matches("^[6-9][0-9]{9}"))) {

			// isValid=false;
			throw new CustomerException(CustomerExceptionMessage.ERROR5);
		}
		if ((customer.getEmailId() == null || !(customer.getEmailId()
				.matches("[a-zA-Z][a-zA-z0-9-.]*@[a-zA-Z0-9]+([.][a-zA-Z)]+)+")))) {

			// isValid=false;
			throw new CustomerException(CustomerExceptionMessage.ERROR3);
		}
		if ((customer.getPanNum() == null)
				|| (!(customer.getPanNum().matches("^[A-Z][A-Z0-9]{9}")))) {

			// isValid=false;
			throw new CustomerException(CustomerExceptionMessage.ERROR4);
		}
		if ((customer.getAddress() == null)
				|| (!(customer.getAddress().matches("[A-Za-z]{5,50}")))) {
			// isValid=false;
			throw new CustomerException(CustomerExceptionMessage.ERROR7);
		}
		if (customer.getBalance() == 0 || !(customer.getBalance() > 0)) {
			// isValid=false;
			throw new CustomerException(CustomerExceptionMessage.ERROR6);

		}

		return isValid;

	}

	public boolean validateShowBalance(BigInteger phoneNo) throws Exception {
		boolean isValid = true;
		if (!(phoneNo.toString().matches("^[6-9][0-9]{9}"))) {

			isValid = false;
			throw new CustomerException(CustomerExceptionMessage.ERROR5);
		}
		return isValid;

	}

	public boolean validateDeposit(double amount, BigInteger phoneNo)
			throws CustomerException {
		boolean isValid = true;
		// DepositBean depositBean = new DepositBean();
		if (!(phoneNo.toString().matches("^[6-9][0-9]{9}"))) {

			isValid = false;
			throw new CustomerException(CustomerExceptionMessage.ERROR5);
		} else {
			isValid = true;

			// System.out.println("deposit");
			// throw new CustomerException(CustomerExceptionMessage.ERROR6);

		}

		return isValid;

	}

	public boolean validateWithdraw(double amount, BigInteger phoneNo)
			throws CustomerException {
		boolean isValid = true;
		if (!(phoneNo.toString().matches("^[6-9][0-9]{9}"))) {

			isValid = false;
			throw new CustomerException(CustomerExceptionMessage.ERROR5);
		} else {
			isValid = true;

		}

		return isValid;
	}

	public boolean validateFundTransfer(double amount, BigInteger anotherPhoneNo)
			throws Exception {
		boolean isValid = true;
		if (!(anotherPhoneNo.toString().matches("^[6-9][0-9]{9}"))) {

			isValid = false;
			throw new CustomerException(CustomerExceptionMessage.ERROR5);
		}
		if (amount == 0 || (!(amount > 0))) {
			isValid = false;
			throw new CustomerException(CustomerExceptionMessage.ERROR6);

		}

		return isValid;
	}

}
