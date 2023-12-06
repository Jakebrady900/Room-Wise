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

	public Customer() {
		customerId = IdService.getNextCustomerID();
	}

}
