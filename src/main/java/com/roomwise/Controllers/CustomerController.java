package com.roomwise.Controllers;

import com.roomwise.Models.Customer;
import com.roomwise.Services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/register")
    public String makeCustomer(@RequestBody Customer resrvation) {
        customerService.saveCustomer(resrvation);
        return "saved sucessfully";
    }
    
    @GetMapping("/getAllCustomers")
    public List<Customer> getAllCustomer() {
        return customerService.showCustomers();
    }

    @GetMapping("/getCustomer/{id}")
    public String getCustomerByID(@PathVariable Long Id) {
        if (customerService.findCustomerById(Id).isPresent()) {
            return "Found : " + customerService.findCustomerById(Id).get();
        } else {
            return "no such customer";
        }
    }

     //Admin
    public String sendNotification(@PathVariable Customer customer ,@PathVariable String message) {
       return customerService.sendNotificationToCustomer(customer, message);
    }

}
