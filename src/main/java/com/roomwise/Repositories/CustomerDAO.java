package com.roomwise.Repositories;

import com.roomwise.Models.Customer;
import com.roomwise.Models.Reservation;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CustomerDAO {

    List<Customer> CustomerDB = new ArrayList<>();

    public void save(Customer customer) {
        CustomerDB.add(customer);
    }

    public List<Customer> getCustomers() {
        return CustomerDB;
    }

    public Customer findById(int customerId) {
        for (Customer customer : CustomerDB) {
            if (customer.getCustomerId() == customerId) {
                return customer;
            }
        }
        return null;
    }

    public String deleteById(int customerId) {
       for(Customer customer : CustomerDB){
           if(customer.getCustomerId() == customerId){
               CustomerDB.remove(customer);
               return "Customer Deleted";
           }
       }
       return "No Such Customer";
    }

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