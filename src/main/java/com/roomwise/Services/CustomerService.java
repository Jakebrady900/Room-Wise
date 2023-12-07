package com.roomwise.Services;

import com.roomwise.Models.Customer;
import com.roomwise.Notification.InotificationCommand;
import com.roomwise.Repositories.CustomerDAO;

import com.roomwise.config.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerDAO customerRepository;
    public CustomerService(CustomerDAO customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    public Boolean updateCustomer(Customer customer) {
        return customerRepository.updateCustomer(customer);
    }
    public List<Customer> showCustomers() {
        return customerRepository.getCustomers();
    }

    public Customer findCustomerById(Integer customerId) {
        return customerRepository.findById(customerId);
    }

    public String deleteCustomer(int customerId) {
        return customerRepository.deleteById(customerId);
    }

       public String sendNotificationToCustomer(Customer customer, String message,InotificationCommand EmailNotificationCommand) {
        return EmailNotificationCommand.execute(customer, message);
    }

}
