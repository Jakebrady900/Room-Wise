package com.roomwise.Models;

import com.roomwise.Services.IdService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Getter @Setter
public class Customer {

	private Integer customerId;

	private String name;

	private Integer age;

	private long contact;

	private String email;

	private String username;
	private String password;
	
	// Here i am initialising constructors and declaring variables
	public Customer() {
		customerId = IdService.getNextCustomerID();
	}

	public Customer(String name, Integer age, long contact, String email, String username, String password) {
		this.name = name;
		this.age = age;
		this.contact = contact;
		this.email = email;
		this.username = username;
		this.password = password;
	}

	public Customer(String name, String username, String password) {
		this.name = name;
		this.username = username;
		this.password = password;
	}
}
