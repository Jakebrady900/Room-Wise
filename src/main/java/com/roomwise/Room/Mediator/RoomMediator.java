package com.roomwise.Room.Mediator;

import com.roomwise.Room.RoomClassification.RoomClassification;
import com.roomwise.Room.RoomClassification.StandardRoom;
import com.roomwise.Room.RoomType.Content;
import com.roomwise.Room.RoomType.RoomType;
import jakarta.persistence.Embeddable;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Embeddable
@NoArgsConstructor
public class RoomMediator implements Mediator {


    public BigDecimal getCharge(RoomType roomType, RoomClassification roomClassification) {
        BigDecimal Charge;

        Charge = roomClassification.getCharge();
        if (roomClassification instanceof StandardRoom) {
            for (Content content : roomType.get_roomContents()) {
                Charge = Charge.add(content.getCost());
            }
        }

        Charge = Charge.add(roomType.get_basePrice());

        return Charge;
    }
}
