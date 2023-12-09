package com.roomwise.Models;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.roomwise.Services.IdService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Getter @Setter
public class Payment {

	// Attributes of the Payment class

	private Integer paymentId;

 	private LocalDate paymentDate;

 	private BigDecimal amount;

	private boolean paymentStatus;

	// Constructor

    // Constructor for creating a Payment object with specific attributes

	public Payment(Integer paymentId, LocalDate paymentDate, double amount){
		this.paymentId = paymentId;
        this.paymentDate = paymentDate;
		this.amount = BigDecimal.valueOf(amount);
	}

	// Constructor for creating a Payment object with a specific paymentId

	public Payment(Integer paymentId){
		this.paymentId = paymentId;
	}

	// Getter method for paymentStatus

	public boolean getPaymentStatus() {
		return paymentStatus;
	}

	// Default constructor to initialize paymentId using IdService

	public Payment() {
		paymentId = IdService.getNextPaymentID();
	}

	//connect to rest of the app


}
