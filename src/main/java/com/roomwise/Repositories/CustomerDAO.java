package com.roomwise.Repositories;

import com.roomwise.Models.Customer;
import com.roomwise.Models.Reservation;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CustomerDAO {

    // Database representation: list to store customers
    List<Customer> CustomerDB = new ArrayList<>();

     // Method to save a customer to the database
    public void save(Customer customer) {
        CustomerDB.add(customer);
    }

    // Method to retrieve all customers from the database
    public List<Customer> getCustomers() {
        return CustomerDB;
    }

     // Method to find a customer by their ID in the database
    public Customer findById(int customerId) {
        for (Customer customer : CustomerDB) {
            if (customer.getCustomerId() == customerId) {
                return customer;
            }
        }
        return null;//customer not found
    }

     // Method to delete a customer by their ID from the database
    public String deleteById(int customerId) {
       for(Customer customer : CustomerDB){
           if(customer.getCustomerId() == customerId){
               CustomerDB.remove(customer);
               return "Customer Deleted";
           }
       }
       return "No Such Customer";
    }

     // Method to update customer information in the database
    public boolean updateCustomer(Customer customerUpdate) {
        for (int i = 0; i < CustomerDB.size(); i++) {
            Customer customer = CustomerDB.get(i);
            if (customer.getCustomerId().equals(customerUpdate.getCustomerId())) {
                CustomerDB.set(i, customerUpdate);
                return true; // Updated successfully
            }
        }
        return false; // Item not found
    }


}