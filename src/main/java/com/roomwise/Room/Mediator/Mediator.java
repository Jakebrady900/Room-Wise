package com.roomwise.Room.Mediator;

import com.roomwise.Room.RoomClassification.RoomClassification;
import com.roomwise.Room.RoomType.RoomType;
import jakarta.persistence.Embeddable;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Embeddable
public interface Mediator {
    BigDecimal getCharge(RoomType roomType, RoomClassification roomClassification);
}
