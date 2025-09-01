package a02accscenario.model;

public class AccountStatus {
	
	private int statusCode;
	private String statusMessage;
	private Account account;
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getStatusMessage() {
		return statusMessage;
	}
	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public AccountStatus(int statusCode, String statusMessage, Account account) {
		super();
		this.statusCode = statusCode;
		this.statusMessage = statusMessage;
		this.account = account;
	}
	public AccountStatus() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
