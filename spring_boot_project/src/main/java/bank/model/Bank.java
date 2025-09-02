package bank.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Bank {

    @Id
    private int bankId;
    private String bankName;
    private String address;
    private String headoffice;
    private int rbiapprovalid;

    public Bank() {
    }

    public Bank(int bankId, String bankName, String address, String headoffice, int rbiapprovalid) {
        this.bankId = bankId;
        this.bankName = bankName;
        this.address = address;
        this.headoffice = headoffice;
        this.rbiapprovalid = rbiapprovalid;
    }

    public int getBankId() {
        return bankId;
    }

    public void setBankId(int bankId) {
        this.bankId = bankId;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHeadoffice() {
        return headoffice;
    }

    public void setHeadoffice(String headoffice) {
        this.headoffice = headoffice;
    }

    public int getRbiapprovalid() {
        return rbiapprovalid;
    }

    public void setRbiapprovalid(int rbiapprovalid) {
        this.rbiapprovalid = rbiapprovalid;
    }
}
