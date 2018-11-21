package com.capg.paymentwallet.test;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Assert;
import org.junit.BeforeClass;



import org.junit.Test;

import com.capg.paymentwallet.bean.CustomerBean;
import com.capg.paymentwallet.bean.DepositBean;
import com.capg.paymentwallet.bean.FundTransferBean;
import com.capg.paymentwallet.bean.ShowBalaneBean;
import com.capg.paymentwallet.bean.WithdrawBean;
import com.capg.paymentwallet.database.CustomerDataBase;
import com.capg.paymentwallet.exception.CustomerException;
import com.capg.paymentwallet.service.CustomerServiceImpl;

//@FixMethodOrder(MethodSorters.NAME_ASCENDING)



public class CustomerServiceImplTest {

		private static CustomerServiceImpl service = null;

		@BeforeClass
		public static void createInstance() {
			service = new CustomerServiceImpl();
		}
		

		@Test(expected=CustomerException.class)
		public void testFirstNameNull() throws CustomerException {
			CustomerBean customer = new CustomerBean();
			customer.setFirstName(" "); 
			customer.setLastName("ajayutyuy");
            customer.setPhoneNo(new BigInteger("8465023240"));
			customer.setAddress("chennai");
			customer.setEmailId("vjjjvjg@gmail.com");
			customer.setPanNum("HDH909HJH9");
			customer.setBalance(1000.0);
			boolean result1=service.createAccount(customer);
			assertFalse(result1);
			
			
		}

		@Test(expected = CustomerException.class)
		public void testFirstNameForLength() throws CustomerException {
			CustomerBean customer = new CustomerBean();

			customer.setFirstName("kk");
			customer.setLastName("ajay");
			customer.setPhoneNo(new BigInteger("8465023240"));
			customer.setAddress("chennai");
			customer.setEmailId("vjjjvjg@gmail.com");
			customer.setPanNum("HDH909HJH9");
			customer.setBalance(1000.0);
			boolean result=service.createAccount(customer);
			assertFalse(result);
		}
		@Test(expected = CustomerException.class)
		public void testFirstNameOnlyForAlphabets() throws CustomerException {
			CustomerBean customer = new CustomerBean();

			customer.setFirstName("123");
			customer.setLastName("ajay");
			customer.setPhoneNo(new BigInteger("8465023240"));
			customer.setAddress("chennai");

			customer.setEmailId("vjjjvjg@gmail.com");
			customer.setPanNum("HDH909HJH9");
			customer.setBalance(1000.0);

			boolean result=service.createAccount(customer);

			assertFalse(result);
		}
		@Test
		public void testFirstNamePsositive() throws CustomerException {
			CustomerBean customer = new CustomerBean();

			customer.setFirstName("kaushik");
			customer.setLastName("ajay");
			customer.setPhoneNo(new BigInteger("8465023240"));
			customer.setAddress("HYDERABADDD");
			customer.setEmailId("vjjjvjg@gmail.com");
			customer.setPanNum("HDHHHH9099");
			customer.setBalance(1000.0);

			boolean result=service.createAccount(customer);
			assertTrue(result);
		}
		@Test(expected = NullPointerException.class)
		public void testlastNameForNull() throws CustomerException {
			CustomerBean customer = new CustomerBean();

			customer.setFirstName("kaushik");
			customer.setLastName(null);
			customer.setPhoneNo(new BigInteger("8465023240"));
			customer.setAddress("CHhennai");

			customer.setEmailId("vjjjvjg@gmail.com");
			customer.setPanNum("HDH909HJH9");
			customer.setBalance(1000.0);

			boolean result=service.createAccount(customer);
			assertFalse(result);
		}
		
		

		

		@Test(expected = CustomerException.class)
		public void testlastNameForLength() throws CustomerException {
			CustomerBean customer = new CustomerBean();

			customer.setFirstName("kaushik");
			customer.setLastName("aj");
			customer.setPhoneNo(new BigInteger("8465023240"));
			customer.setAddress("chennai");

			customer.setEmailId("vjjjvjg@gmail.com");
			customer.setPanNum("HDH909HJH9");
			customer.setPhoneNo(new BigInteger("7454637645"));
			customer.setBalance(1000.0);

			boolean result=service.createAccount(customer);
			assertFalse(result);
		}

		@Test(expected = CustomerException.class)
		public void testlastNameForOnlyCharacters() throws CustomerException {
			CustomerBean customer = new CustomerBean();

			customer.setFirstName("kaushik");
			customer.setLastName("456");

			customer.setAddress("chennai");

			customer.setEmailId("vjjjvjg@gmail.com");
			customer.setPanNum("HDH909HJH9");
			customer.setPhoneNo(new BigInteger("9963144561"));
			customer.setBalance(1000.0);

			boolean result=service.createAccount(customer);
			assertFalse(result);
		}
		

		@Test
		public void testLastNameValid() throws CustomerException {
			CustomerBean customer = new CustomerBean();

			customer.setFirstName("kaushik");
			customer.setLastName("ajay");

			customer.setAddress("chennai");

			customer.setEmailId("vjjjvjg@gmail.com");
			customer.setPanNum("HDH909HJH9");
			customer.setPhoneNo(new BigInteger("8465023240"));
			customer.setBalance(1000.0);
			boolean result=service.createAccount(customer);
			assertTrue(result);

		}

		@Test(expected = CustomerException.class)
		public void testPhnoForLength() throws CustomerException {
			CustomerBean customer = new CustomerBean();

			customer.setFirstName("kaushik");
			customer.setLastName("ajay");

			customer.setAddress("chennai");

			customer.setEmailId("vjjjvjg@gmail.com");
			customer.setPanNum("HDH909HJH9");
			customer.setPhoneNo(new BigInteger("9963"));
			customer.setBalance(1000.0);

			boolean result=service.createAccount(customer);
			assertFalse(result);
		}

		@Test(expected = CustomerException.class)
		public void testPhonenoInvalidBegining() throws CustomerException {
			CustomerBean customer = new CustomerBean();
			customer.setFirstName("kaushik");
			customer.setLastName("ajay");
			customer.setAddress("chennai");
			customer.setEmailId("vjjjvjg@gmail.com");
			customer.setPanNum("HDH909HJH9");
			customer.setPhoneNo(new BigInteger("5287525236"));
			customer.setBalance(1000);
			boolean result=service.createAccount(customer);
			assertFalse(result);
		}
				
		@Test
		public void testPhoneNumPositive() throws CustomerException {
			CustomerBean customer = new CustomerBean();

			customer.setFirstName("kaushik");
			customer.setLastName("ajay");

			customer.setAddress("chennai");

			customer.setEmailId("vjjjvjg@gmail.com");
			customer.setPanNum("HDHFGH6784");
			customer.setPhoneNo(new BigInteger("9963144561"));
			customer.setBalance(1000);

			boolean result=service.createAccount(customer);
			assertTrue(result);
		}

		@Test(expected = CustomerException.class)
		public void testEmailIdForNull() throws CustomerException {
			CustomerBean customer = new CustomerBean();

			customer.setFirstName("kaushik");
			customer.setLastName("ajay");

			customer.setAddress("chennai");

			customer.setEmailId("");
			customer.setPanNum("HDH909HJH9");
			customer.setPhoneNo(new BigInteger("9963144561"));
			customer.setBalance(1000);

			boolean result=service.createAccount(customer);
			assertFalse(result);
		}

		@Test(expected = CustomerException.class)
		public void testEmailIdInvalid() throws CustomerException {
			CustomerBean customer = new CustomerBean();

			customer.setFirstName("kaushik");
			customer.setLastName("ajay");

			customer.setAddress("chennai");

			customer.setEmailId(".com@fhgfhf");
			customer.setPanNum("HDH909HJH9");
			customer.setPhoneNo(new BigInteger("9963144561"));
			customer.setBalance(1000);

			boolean result=service.createAccount(customer);
			assertFalse(result);
		}

		@Test
		public void testEmailIdValid() throws CustomerException {
			CustomerBean customer = new CustomerBean();

			customer.setFirstName("kaushik");
			customer.setLastName("ajay");

			customer.setAddress("chennai");

			customer.setEmailId("kowshik.ajay@gmail.com");
			customer.setPanNum("HDH909HJH9");
			customer.setPhoneNo(new BigInteger("9963144561"));		
			customer.setBalance(1000);
			
			boolean result=service.createAccount(customer);
			assertTrue(result);
		}

		@Test
		public void testpanNumValid() throws CustomerException {
			CustomerBean customer = new CustomerBean();

			customer.setFirstName("kaushik");
			customer.setLastName("ajay");

			customer.setAddress("chennai");

			customer.setEmailId("kowshik.ajay@gmail.com");
			customer.setPanNum("HDH909HJH9");
			customer.setPhoneNo(new BigInteger("9963144561"));
			customer.setBalance(1000);

			boolean result=service.createAccount(customer);
			assertTrue(result);
		}

		@Test(expected = CustomerException.class)
		public void testpanNumlength() throws CustomerException {
			CustomerBean customer = new CustomerBean();

			customer.setFirstName("kaushik");
			customer.setLastName("ajay");

			customer.setAddress("chennai");

			customer.setEmailId("kowshik.ajay@gmail.com");
			customer.setPanNum("HDH90");
			customer.setPhoneNo(new BigInteger("9963144561"));
			customer.setBalance(1000);

			boolean result=service.createAccount(customer);
			assertFalse(result);
		}

		@Test(expected = CustomerException.class)
		public void testpanNumForNull() throws CustomerException {
			CustomerBean customer = new CustomerBean();

			customer.setFirstName("kaushik");
			customer.setLastName("ajay");

			customer.setAddress("chennai");
			;
			customer.setEmailId("kowshik.ajay@gmail.com");
			customer.setPanNum("");
			customer.setPhoneNo(new BigInteger("9963144561"));
			customer.setBalance(1000);

			boolean result=service.createAccount(customer);
			assertFalse(result);
		}

		@Test(expected = CustomerException.class)
		public void testpanNumInValid() throws CustomerException {
			CustomerBean customer = new CustomerBean();

			customer.setFirstName("kaushik");
			customer.setLastName("ajay");

			customer.setAddress("chennai");

			customer.setEmailId("kowshik.ajay@gmail.com");
			customer.setPanNum("GHSDJ@75$");
			customer.setPhoneNo(new BigInteger("9963144561"));
			customer.setBalance(1000);

			boolean result=service.createAccount(customer);
			assertFalse(result);
		}

		@Test(expected = CustomerException.class)
		public void testpanNumForOnlyNum() throws CustomerException {
			CustomerBean customer = new CustomerBean();

			customer.setFirstName("kaushik");
			customer.setLastName("ajay");

			customer.setAddress("chennai");

			customer.setEmailId("kowshik.ajay@gmail.com");
			customer.setPanNum("9966332211");
			customer.setPhoneNo(new BigInteger("9963144561"));
			customer.setBalance(1000);

			boolean result=service.createAccount(customer);
			assertFalse(result);
		}
	
		
		  
		@Test(expected = CustomerException.class)
		public void testbalance() throws CustomerException {
			CustomerBean customer = new CustomerBean();

			customer.setFirstName("kaushik");
			customer.setLastName("ajay");

			customer.setAddress("chennai");
		
			customer.setEmailId("kowshik.ajay@gmail.com");
			customer.setPanNum("HDH909HJH9");
			customer.setPhoneNo(new BigInteger("9963144561"));
			customer.setBalance(-777);

			boolean result=service.createAccount(customer);
			assertFalse(result);
		}

		@Test(expected = CustomerException.class)
		public void testbalanceInvalid() throws CustomerException {
			CustomerBean customer = new CustomerBean();

			customer.setFirstName("kaushik");
			customer.setLastName("ajay");

			customer.setAddress("chennai");
			customer.setEmailId("kowshik.ajay@gmail.com");
			customer.setPanNum("HDH909HJH9");
			customer.setPhoneNo(new BigInteger("9963144561"));
			customer.setBalance(0);

			boolean result=service.createAccount(customer);
			assertTrue(result);
		}

		@Test
		public void testBalanceValid() throws CustomerException {
			CustomerBean customer = new CustomerBean();

			customer.setFirstName("kaushik");
			customer.setLastName("ajay");

			customer.setAddress("chennai");
			customer.setEmailId("kowshik.ajay@gmail.com");
			customer.setPanNum("HDH909HJH9");
			customer.setPhoneNo(new BigInteger("9963144561"));
			customer.setBalance(1000);

			boolean result=service.createAccount(customer);
			assertTrue(result);
		}

		@Test
		public void testAddressValid() throws CustomerException {
			CustomerBean customer = new CustomerBean();
			customer.setFirstName("kaushik");
			customer.setLastName("ajay");
			customer.setAddress("chennai");
			customer.setEmailId("kowshik.ajay@gmail.com");
			customer.setPanNum("HDH909HJH9");
			customer.setPhoneNo(new BigInteger("9963144561"));
			customer.setBalance(1000);
			boolean result=service.createAccount(customer);
			assertTrue(result);
		}
	@Test
			
		public void testAForShowBalanceNotSame() throws Exception  {
			
		
		double result=service.showBalance(new BigInteger("8465033299"));
		Assert.assertEquals(2000.0, result,0);

			
		}
//		@Test
//		
//		public void testForShowBalanceSame()  {
//					
//		double result=service.showBalance(new BigInteger("8465033260"));
//		Assert.assertEquals(2000.0,result,0);
 // }
//	
		
		@Test
		public void testBForFundTransfer() {
			
			double result = service.fundTransfer(new BigInteger("8465033260"), 500.0, new BigInteger("8465033260"));
			Assert.assertEquals(1500.0,result,0);
		}
		@Test
		public void testCForWithdraw() throws CustomerException {
		
			
			double result = service.withdraw(new BigInteger("8465033260"),1000.0);
			Assert.assertEquals(500.0,result,0);
		}
		@Test
		public void testDForDeposit() throws CustomerException  {
			double result = service.deposit(new BigInteger("8465033260"), 2000.0);
			Assert.assertEquals(2500.0, result,0);
		}
		/*@Test
		public void testForFundTransferInvalid() {
			
			double result = service.fundTransfer(new BigInteger("8465039960"), 500.0, new BigInteger("8465033260"));
			Assert.assertNotEquals(1500.0,result,0);
		}
		@Test
		public void testForFundTransferInvalidAmount() {
			
			double result = service.fundTransfer(new BigInteger("8465039960"), 50000.0, new BigInteger("8465033260"));
			Assert.assertNotEquals(1500.0,result,0);
		}
		
		
		
		@Test
		public void testForWithdrawInvalid() {
		
			
			double result = service.withdraw(new BigInteger("8465044260"),1000.0);
			Assert.assertNotEquals(500.0,result,0);
		}
		@Test
		public void testForWithdrawInvalidAmount() {
		
			
			double result = service.withdraw(new BigInteger("8465044260"),10000.0);
			Assert.assertNotEquals(500.0,result,0);
		}
		
		@Test
		public void testForDepositInvalid()  {
			double result = service.deposit(new BigInteger("8466033260"), 2000.0);
			Assert.assertNotEquals(2500.0, result,0);
		}*/
		@Test
		public void testForPrintTransaction() throws Exception{
			service.showBalance( new BigInteger ("8465033260"));
            service.withdraw( new BigInteger ("8465033260"),500);
            service.deposit(new BigInteger ("8465033260"),500);
         
            
			service.printTransaction();
		}
		
		
}