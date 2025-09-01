package a02accscenario.service;

import a02accscenario.dao.AccountDao;
import a02accscenario.dao.AccountDaoImplementation;
import a02accscenario.model.AccountStatus;

public class AccountServiceImplementation implements AccountService {
	
	private AccountDao accountdao;
	
	
	
		public AccountServiceImplementation() {
			
			accountdao =new AccountDaoImplementation();
			
			
		
		// TODO Auto-generated constructor stub
	}



		@Override
	public AccountStatus getBalance(int accountno, int pin) {
		// TODO Auto-generated method stub
			System.out.println("in the service function , about to call dao ");
		AccountStatus i = accountdao.getAccountDetailsFromDB(accountno,pin);
		System.out.println("finished returning from dao , in service function");
		return i;
		
	}

}
