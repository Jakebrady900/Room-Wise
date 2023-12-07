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

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/register")
    public String saveCustomer(@RequestBody Customer customer) {
        customerService.saveCustomer(customer);
        return "saved sucessfully";
    }

    @GetMapping("/getAllCustomers")
    public List<Customer> getAllCustomer() {
        return customerService.showCustomers();
    }

    @GetMapping("/updateCustomer/")
    public String updateCustomer(@RequestBody Customer customer) {
        boolean CustomerUpd = customerService.updateCustomer(customer);
        return CustomerUpd?"Updated successfully":"No Such Customer";
    }
    @GetMapping("/getCustomer/{id}")
    public Customer getCustomerByID(@PathVariable("customerId") int customerId) {
        return customerService.findCustomerById(customerId);
    }

    @GetMapping("/deleteCustomer/{customerId}")
    public String deleteCustomerByID(@PathVariable int customerId) {
            return customerService.deleteCustomer(customerId);
    }

     //Admin
     @GetMapping("/SendNotification/{customerId}/{message}")
     public String sendNotification(@PathVariable("customerId") Integer customerId, @PathVariable("message") String message) {
         // Retrieve customer by ID from the database
         Customer customer = customerService.findCustomerById(customerId);

         if(customer != null) {
             return customerService.sendNotificationToCustomer(customer, message, new EmailNotificationCommand());
         } else {
             return "Customer not found";
         }
     }

}
