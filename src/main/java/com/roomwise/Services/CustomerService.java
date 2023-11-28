package com.roomwise.Services;

import com.roomwise.Models.Customer;
import com.roomwise.Repositories.CustomerDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerDAO customerRepository;

    public void saveCustomer(@RequestBody Customer customer) {
        customerRepository.save(customer);
    }

    public List<Customer> showCustomers() {
        return customerRepository.findAll();
    }

    public Optional<Customer> findCustomerById(Long customerId) {
        return customerRepository.findById(customerId);
    }

    public void deleteCustomer(Long customerId) {
        customerRepository.deleteById(customerId);
    }

}
