package com.roomwise.Models;

import java.time.LocalDate;
//import java.util.Collection;
//import java.util.List;


//import jakarta.persistence.Column;
import jakarta.persistence.Entity;
//import jakarta.persistence.EnumType;
//import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity

public class Payment {

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long paymentId;

 	private Long reservationId;

 	private LocalDate paymentDate;

 	private double amount;

	private boolean paymentStatus;



	 
	//connect to rest of the app  

    
}
