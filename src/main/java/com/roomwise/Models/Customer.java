package com.roomwise.Models;

import java.util.Collection;
import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Customer {

	private Integer customerId;

	private String name;

	private Integer age;

	private long contact;

	private String email;

	private String username;
	private String password;


	// connection to resrvation

}
