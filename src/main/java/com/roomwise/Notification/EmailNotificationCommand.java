package com.roomwise.Notification;

import com.roomwise.Models.Customer;

// Implementation of the InotificationCommand interface for email notifications
public class EmailNotificationCommand implements InotificationCommand {
    @Override
     // Method to execute email notification for a given customer with a message
    public String execute(Customer customer, String message) {
        // mockup of an email notification

        // Constructing the notification message
        String returnString = "Email sent to " + customer.getEmail() + ": " + message;
        return returnString;
    }
}