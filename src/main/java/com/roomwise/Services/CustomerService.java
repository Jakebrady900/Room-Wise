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
     // Constructor injection for CustomerDAO
    public CustomerService(CustomerDAO customerRepository) {
        this.customerRepository = customerRepository;
    }

    // Method to save a customer using the CustomerDAO
    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    // Method to update a customer using the CustomerDAO and return update status
    public Boolean updateCustomer(Customer customer) {
        return customerRepository.updateCustomer(customer);
    }
    // Method to retrieve all customers using the CustomerDAO
    public List<Customer> showCustomers() {
        return customerRepository.getCustomers();
    }

    // Method to find a customer by ID using the CustomerDAO
    public Customer findCustomerById(Integer customerId) {
        return customerRepository.findById(customerId);
    }

     // Method to delete a customer by ID using the CustomerDAO
    public String deleteCustomer(int customerId) {
        return customerRepository.deleteById(customerId);
    }

         // Method to send a notification to a customer using a specified notification command
       public String sendNotificationToCustomer(Customer customer, String message,InotificationCommand EmailNotificationCommand) {
        return EmailNotificationCommand.execute(customer, message);
    }

     // Method to check if a customer with a given ID exists in the CustomerDAO
    public boolean isValidCustomer(int customerId){
        return customerRepository.findById(customerId)!= null;
    }

}
