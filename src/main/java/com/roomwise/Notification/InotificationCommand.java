package com.roomwise.Notification;


import com.roomwise.Models.Customer;

// Interface defining the structure for notification commands
public interface InotificationCommand {
     // Method signature for executing a notification command for a customer with a message
    String execute(Customer customer, String message);


}
