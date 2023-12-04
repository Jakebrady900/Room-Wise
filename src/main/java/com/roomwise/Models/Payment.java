package com.roomwise.Models;

import java.time.LocalDate;
//import java.util.Collection;
//import java.util.List;


//import jakarta.persistence.Column;
//import jakarta.persistence.EnumType;
//import jakarta.persistence.Enumerated;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Payment {

	private Long paymentId;

 	private Long reservationId;

 	private LocalDate paymentDate;

 	private double amount;

	private boolean paymentStatus;




	//connect to rest of the app


}
