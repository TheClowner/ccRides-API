package net.clownercraft.ccRides.API.events;

import lombok.Getter;
import lombok.Setter;
import net.clownercraft.ccRides.API.ride.Ride;

/**
 * Fired when a ride stops running
 */
@Getter @Setter
public class RideStopEvent extends RideEvent {
    public enum RideStopReason {
        SEQUENCE_END,
        COMMAND,
        RIDE_DISABLED,
        CHUNK_UNLOAD,
        UNKNOWN
    }
    RideStopReason reason;

    public RideStopEvent(Ride ride, RideStopReason reason) {
        super(ride);
        this.reason = reason;
    }

}
