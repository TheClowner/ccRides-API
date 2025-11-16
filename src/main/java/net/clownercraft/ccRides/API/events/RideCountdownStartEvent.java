package net.clownercraft.ccRides.API.events;

import net.clownercraft.ccRides.API.ride.Ride;

/**
 * Triggered when a ride's countdown is started (i.e. enough players join)
 */
public class RideCountdownStartEvent extends RideEvent {

    /**
     * Create a new CountdownStartEvent
     * @param ride The ride which started it's countdown
     */
    public RideCountdownStartEvent(Ride ride) {
        super(ride);
    }
}
