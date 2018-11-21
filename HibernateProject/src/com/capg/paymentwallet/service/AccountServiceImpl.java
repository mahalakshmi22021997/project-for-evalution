package com.capg.paymentwallet.service;

import com.capg.paymentwallet.bean.AccountBean;
import com.capg.paymentwallet.dao.AccountDAOImpl;
import com.capg.paymentwallet.dao.IAccountDao;
import com.capg.paymentwallet.exception.CustomerException;
import com.capg.paymentwallet.exception.CustomerExceptionMessage;


public class AccountServiceImpl implements IAccountService{

	IAccountDao dao=new AccountDAOImpl();
	@Override
	public boolean createAccount(AccountBean accountBean)
			throws Exception {
		validations(accountBean);
		
		return dao.createAccount(accountBean);
		
		
	}

	

	@Override
	public boolean deposit(AccountBean accountBean, double depositAmount)
			throws Exception {
		
	     return dao.deposit(accountBean, depositAmount);
	}

	@Override
	public boolean withdraw(AccountBean accountBean, double withdrawAmount)
			throws Exception {
		return dao.withdraw(accountBean, withdrawAmount);
	}
	
	@Override
	public boolean fundTransfer(AccountBean transferingAccountBean,
			AccountBean beneficiaryAccountBean, double transferAmount) throws Exception {
		
		
		
		/*IAccountDao dao=new AccountDAOImpl();
		boolean result1=dao.updateAccount(transferingAccountBean);
		boolean result2=dao.updateAccount(beneficiaryAccountBean);*/
		return dao.fundTransfer(transferingAccountBean, beneficiaryAccountBean, transferAmount);
	
	}
	



	@Override
	public AccountBean findAccount(int accountId) throws Exception {
		IAccountDao dao=new AccountDAOImpl();
		AccountBean bean=dao.findAccount(accountId);
		return bean;
	}
	public boolean validations(AccountBean accountBean) throws CustomerException {
		boolean isValid = false;
		if (accountBean.getCustomerBean().getFirstName().trim().length() < 4) {
			throw new CustomerException(CustomerExceptionMessage.ERROR1);
		} else if (accountBean.getCustomerBean().getLastName().trim().length() < 4) {
			throw new CustomerException(CustomerExceptionMessage.ERROR2);
		} else if (!(String.valueOf(accountBean.getCustomerBean().getPhoneNo())
				.matches("(0)?[6-9][0-9]{9}"))) {
			throw new CustomerException(CustomerExceptionMessage.ERROR5);
		}  else if (accountBean.getCustomerBean().getAddress().length() == 0) {
			throw new CustomerException(CustomerExceptionMessage.ERROR7);
		} else if (!(accountBean.getCustomerBean().getEmailId()
				.matches("[a-z0-9]+@gmail\\.com"))) {
			throw new CustomerException(CustomerExceptionMessage.ERROR3);
		}else if (!(accountBean.getCustomerBean().getPanNum().matches("[A-Z]{5}[0-9]{5}"))){
			throw new CustomerException(CustomerExceptionMessage.ERROR4);
		}
		else {
			isValid = true;
		}
		return isValid;
	}



	@Override
	public String gender(String string) {
		 AccountBean accountBean =new AccountBean();
			
			if(accountBean.getCustomerBean().getGender().equals("F"))
			{
				return "Mrs";
			}
			return "Ms" ;
	}

}
