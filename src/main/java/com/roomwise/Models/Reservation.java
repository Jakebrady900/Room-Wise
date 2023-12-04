package com.roomwise.Models;

import java.time.LocalDate;
import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor
public class Reservation {

	private Long reservationId;

	private LocalDate checkinDate;

	private LocalDate checkoutDate;

	private Integer noOfPerson;

	private Integer noOfRooms;

	private List<Integer> RoomsNumber;


	//need a type to determine role
	//connect to rest of the app rooms/customer


}
