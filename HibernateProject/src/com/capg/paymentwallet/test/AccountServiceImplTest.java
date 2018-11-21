package com.capg.paymentwallet.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.capg.paymentwallet.bean.AccountBean;
import com.capg.paymentwallet.bean.CustomerBean;
import com.capg.paymentwallet.exception.CustomerException;
import com.capg.paymentwallet.service.AccountServiceImpl;
import com.capg.paymentwallet.service.IAccountService;

public class AccountServiceImplTest {
    static IAccountService service = null;
    static AccountBean accBean = null;
    static CustomerBean custBean = null;
    @BeforeClass
    public static void createInstance(){
                    service= new AccountServiceImpl();
                    accBean = new AccountBean();
                    custBean = new CustomerBean();
    }
    @Test(expected = CustomerException.class)
    public void testForValidFirstName() throws Exception{
                    custBean.setFirstName("uma");
                    custBean.setLastName("lakshmi");
                    custBean.setPhoneNo("7123456789");
                    custBean.setEmailId("maha@gmail.com");
                    custBean.setPanNum("ASDFG12345");
                    custBean.setAddress("Hyderabad");
                    accBean.setCustomerBean(custBean);
                    accBean.setBalance(1500);
                    boolean result = service.createAccount(accBean);
                    assertFalse(result);
    }
    @Test
    public void testDeposit() throws Exception{
                    custBean.setFirstName("maha");
                    custBean.setLastName("Joseph");
                    custBean.setPhoneNo("9988776655");
                    custBean.setEmailId("priyajoseph@gmail.com");
                    custBean.setPanNum("EXR7890654");
                    custBean.setAddress("Hyderabad");
                    accBean.setCustomerBean(custBean);
                    accBean.setBalance(10000);
                    service.deposit(accBean, 2000);
                    assertEquals(12000,accBean.getBalance(),0);
    
}


    


}
