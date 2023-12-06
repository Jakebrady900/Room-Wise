package com.roomwise.Models;

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

 	private double amount;

	private boolean paymentStatus;


	public Payment() {
		paymentId = IdService.getNextPaymentID();
	}

	//connect to rest of the app


}
