package com.roomwise.Repositories;

import com.roomwise.Models.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CustomerDAO {

    private List<Customer> CustomerDB;

//    Optional<Customer> findByUsername(String username) {
//    }


    public void save(Customer customer) {
        CustomerDB.add(customer);
    }

    public List<Customer> findAll() {
        return null;
        //return CustomerDB.getAll();
    }

    public Optional<Customer> findById(Long customerId) {
        return null;
        //return customerRepository.findById(customerId);
    }

    public void deleteById(Long customerId) {
        //customerRepository.deleteById(customerId);
    }
}