package com.roomwise.Models;

import java.time.LocalDate;
import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor @NoArgsConstructor
public class Reservation {

	private Integer reservationId;

	private Integer customerId;

	private Integer paymentId;

	private LocalDate checkinDate;

	private LocalDate checkoutDate;

	private Integer noOfPerson;

	private Integer noOfRooms;

	private List<Integer> RoomsNumber;

	private boolean paymentStatus;



    //need a type to determine role
	//connect to rest of the app rooms/customer


}
