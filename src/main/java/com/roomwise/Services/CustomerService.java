package com.roomwise.Services;

import com.roomwise.Models.Customer;
import com.roomwise.Models.Reservation;
import com.roomwise.Notification.EmailNotificationCommand;
import com.roomwise.Notification.InotificationCommand;
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
