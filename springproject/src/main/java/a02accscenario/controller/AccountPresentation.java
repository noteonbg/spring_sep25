package a02accscenario.controller;

import a02accscenario.model.AccountStatus;
import a02accscenario.service.AccountService;
import a02accscenario.service.AccountServiceImplementation;

public class AccountPresentation {
	
	private AccountService accService;
	
	
	

	public AccountPresentation() {
		accService =new AccountServiceImplementation();
		// TODO Auto-generated constructor stub
	}




	public void startTheApp() {
		// TODO Auto-generated method stub
		System.out.println("account presentation at work");
		
		int accountno=12;
		int pin =1234;
		
		//below line is the hardest thing in project becuase we cannot copy paste from google.
		
		System.out.println(" in presentation gettng inputs for calling servcie");
		AccountStatus accountStatus = accService.getBalance(accountno,pin);
		System.out.println("in presntation after calling service, thinking what to do");
		
		
		
		
		
		
		
		
	}

}
