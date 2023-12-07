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

	private Integer paymentId;

 	private LocalDate paymentDate;

 	private BigDecimal amount;

	private boolean paymentStatus;

	public Payment(Integer paymentId, LocalDate paymentDate, double amount){
		this.paymentId = paymentId;
        this.paymentDate = paymentDate;
		this.amount = BigDecimal.valueOf(amount);
	}

	public boolean getPaymentStatus() {
		return paymentStatus;
	}

	public Payment() {
		paymentId = IdService.getNextPaymentID();
	}

	//connect to rest of the app


}
