package a11springjpa.service;

import a11springjpa.model.Customer;
import a11springjpa.model.Transaction;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import a11springjpa.model.Customer;
import a11springjpa.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
public class CustomerService {

    @PersistenceContext
    private EntityManager entityManager;

    // Create customer with transactions
    @Transactional
    public Customer createCustomerWithTransactions(Customer customer, Transaction transaction) {

        customer.addTransaction(transaction);
        entityManager.persist(customer); // This will cascade persist to transactions
        return customer;
    }

    // Update transaction
    @Transactional
    public Transaction updateTransaction(Transaction transaction) {
        return entityManager.merge(transaction); // Merge to update an existing transaction
    }

    // Delete customer (Cascade delete transactions)
    @Transactional
    public void deleteCustomer(Long customerId) {
        Customer customer = entityManager.find(Customer.class, customerId);
        if (customer != null) {
            entityManager.remove(customer); // Cascade delete will take care of transactions
        }


    }

    // Delete a specific transaction
    @Transactional
    public void deleteTransaction(Long transactionId) {
        Transaction transaction = entityManager.find(Transaction.class, transactionId);
        if (transaction != null) {
            entityManager.remove(transaction); // Delete the transaction
        }
    }
}
