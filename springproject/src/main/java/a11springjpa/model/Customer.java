package a11springjpa.model;



import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Transaction> transactions;

    // Constructors, Getters, and Setters
    public Customer() { transactions=new ArrayList<Transaction>();}

    public Customer(String name) {
        this.name = name;
    }

    public void addTransaction(Transaction transaction) {
        transactions = transactions !=null ? transactions:new ArrayList<Transaction>();
        transactions.add(transaction);
        transaction.setCustomer(this);
    }

    public void removeTransaction(Transaction transaction) {
        transactions.remove(transaction);
        transaction.setCustomer(null);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}
