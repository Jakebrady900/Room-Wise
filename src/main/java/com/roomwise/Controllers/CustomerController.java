package com.roomwise.Controllers;

import com.roomwise.Models.Customer;
import com.roomwise.Notification.EmailNotificationCommand;
import com.roomwise.Services.CustomerService;
import com.roomwise.config.SecurityConfig;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @Controller
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    // Constructor injection for CustomerController, initializing CustomerService
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    // Endpoint to register a new customer
    @PostMapping("/register")
    public String saveCustomer(@RequestBody Customer customer) {
        customerService.saveCustomer(customer);
        return "saved sucessfully";
    }

    // Endpoint to retrieve all customers
    @GetMapping("/getAllCustomers")
    public List<Customer> getAllCustomer() {
        return customerService.showCustomers();
    }

    // Endpoint to update an existing customer
    @RequestMapping("/updateCustomer")
    public String updateCustomer(@RequestBody Customer customer) {
        boolean CustomerUpd = customerService.updateCustomer(customer);
        return CustomerUpd?"Updated successfully":"No Such Customer";
    }

     // Endpoint to get a customer by ID
    @RequestMapping("/getCustomer/{id}")
    public Customer getCustomerByID(@PathVariable("customerId") int customerId) {
        return customerService.findCustomerById(customerId);
    }

     // Endpoint to delete a customer by ID
    @RequestMapping("/deleteCustomer/{customerId}")
    public String deleteCustomerByID(@PathVariable int customerId) {
            return customerService.deleteCustomer(customerId);
    }

    // Admin Endpoint: Send notification to a customer by ID with a message
    // Use of Command Design pattern
     @RequestMapping("/SendNotification/{customerId}/{message}")
     public String sendNotification(@PathVariable("customerId") Integer customerId, @PathVariable("message") String message) {
          // Retrieve customer by ID from the database using the service
         Customer customer = customerService.findCustomerById(customerId);

         if(customer != null) {
             // Send notification to the customer using specified notification command
             return customerService.sendNotificationToCustomer(customer, message, new EmailNotificationCommand());
         } else {
             return "Customer not found";
         }
     }

}
