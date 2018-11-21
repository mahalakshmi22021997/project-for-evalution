package com.capg.paymentwallet.dao;

import javax.persistence.EntityManager;

import com.capg.paymentwallet.bean.AccountBean;

public class AccountDAOImpl implements IAccountDao {

	
	EntityManager em;
	
	@Override
	public boolean createAccount(AccountBean accountBean) throws Exception {
		try{
			
			this.em=JPAManager.createEntityManager();
			em.getTransaction().begin();
			
			em.persist(accountBean);
			
			em.getTransaction().commit();
			JPAManager.closeResources(em);
			
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	
	}

	/*@Override
	public boolean updateAccount(AccountBean accountBean) throws Exception {
		try{
			this.em=JPAManager.createEntityManager();
			em.getTransaction().begin();
			
			em.merge(accountBean);
			
			em.getTransaction().commit();
			JPAManager.closeResources(em);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	
	}*/

	@Override
	public AccountBean findAccount(int accountId) throws Exception {
		try{
			em=JPAManager.createEntityManager();
			AccountBean accountBean2=em.find(AccountBean.class,accountId);
			JPAManager.closeResources(em);
			return accountBean2;
			
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean deposit(AccountBean accountBean, double depositAmount)
			throws Exception {
	
		try{
			accountBean.setBalance(accountBean.getBalance()+depositAmount);
			this.em=JPAManager.createEntityManager();
			em.getTransaction().begin();
			
			em.merge(accountBean);
			
			em.getTransaction().commit();
			JPAManager.closeResources(em);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean withdraw(AccountBean accountBean, double withdrawAmount)
			throws Exception {
		
			try{
				/*if(accountBean.getBalance()>withdrawAmount){*/
					
				accountBean.setBalance(accountBean.getBalance()-withdrawAmount);

				
				this.em=JPAManager.createEntityManager();
				em.getTransaction().begin();
				
				em.merge(accountBean);
				
				em.getTransaction().commit();
				JPAManager.closeResources(em);
				return true;
			}catch(Exception e){
				e.printStackTrace();
				return false;
			}
			
		
	}
		
	

	@Override
	public boolean fundTransfer(AccountBean transferingAccountBean,
			AccountBean beneficiaryAccountBean, double transferAmount)
			throws Exception {
		// TODO Auto-generated method stub
		
		try{
			/*if(accountBean.getBalance()>withdrawAmount){*/
				
			transferingAccountBean.setBalance(transferingAccountBean.getBalance()-transferAmount);
			beneficiaryAccountBean.setBalance(beneficiaryAccountBean.getBalance()+transferAmount);

			
			this.em=JPAManager.createEntityManager();
			em.getTransaction().begin();
			
			em.merge(transferingAccountBean);
			
			em.getTransaction().commit();
			JPAManager.closeResources(em);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
			}

}
