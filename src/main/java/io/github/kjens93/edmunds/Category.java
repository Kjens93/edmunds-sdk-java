package io.github.kjens93.edmunds;

import lombok.RequiredArgsConstructor;

/**
 * Created by kjensen on 11/20/16.
 */
@RequiredArgsConstructor
public enum Category {
    HATCHBACK_4DR("4dr Hatchback"),
    COUPE("Coupe"),
    CONVERTIBLE("Convertible"),
    SEDAN("Sedan"),
    HATCHBACK_2DR("2dr Hatchback"),
    WAGON("Wagon"),
    PICKUP_REGULAR_CAB("Regular Cab Pickup"),
    PICKUP_EXTENDED_CAB("Extended Cab Pickup"),
    PICKUP_CREW_CAB("Crew Cab Pickup"),
    SUV_2DR("2dr SUV"),
    SUV_4DR("4dr SUV"),
    SUV_CONVERTIBLE("Convertible SUV"),
    CARGO_VAN("Cargo Van"),
    PASSENGER_VAN("Passenger Van"),
    CARGO_MINIVAN("Cargo Minivan"),
    PASSENGER_MINIVAN("Passenger Minivan");

    private final String string;

    @Override
    public String toString() {
        return string;
    }


}
