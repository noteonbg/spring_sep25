package bank.model;

public class BankStatus {

    private int statusCode;
    private String message;
    private Bank bankinfo;

    public BankStatus() {
    }

    public BankStatus(int statusCode, String message, Bank bankinfo) {
        this.statusCode = statusCode;
        this.message = message;
        this.bankinfo = bankinfo;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Bank getBankinfo() {
        return bankinfo;
    }

    public void setBankinfo(Bank bankinfo) {
        this.bankinfo = bankinfo;
    }
}
