package com.roomwise.Notification;

import com.roomwise.Models.Customer;

public class EmailNotificationCommand implements InotificationCommand {
    @Override
    public String execute(Customer customer, String message) {
        // mockup of an email notification

        String returnString = "Email sent to " + customer.getEmail() + ": " + message;
        return returnString;
    }
}