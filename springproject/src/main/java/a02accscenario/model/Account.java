package a02accscenario.model;

public class Account {
	
	private int accountno;
	private String name;
	private int balance;
	private int mobilenumber;
	private int pin;
	public int getAccountno() {
		return accountno;
	}
	public void setAccountno(int accountno) {
		this.accountno = accountno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public int getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(int mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Account(int accountno, String name, int balance, int mobilenumber, int pin) {
		super();
		this.accountno = accountno;
		this.name = name;
		this.balance = balance;
		this.mobilenumber = mobilenumber;
		this.pin = pin;
	}
	
	

}
