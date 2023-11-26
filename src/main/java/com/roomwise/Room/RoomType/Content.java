package com.roomwise.Room.RoomType;

import java.math.BigDecimal;

public enum Content {
    SingleBed(50.0),
    DoubleBed(100.0),
    Crib(30.0),
    AirConditioning(40.0),
    Breakfast(15.0),
    RoomService(20.0),
    CityView(20.0),
    PoolView(5.0);

    private final BigDecimal cost;

    Content(double cost) {
        this.cost = BigDecimal.valueOf(cost);
    }

    public BigDecimal getCost() {
        return this.cost;
    }
}

