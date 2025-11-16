package net.clownercraft.ccRides.API.events;

import lombok.Getter;
import lombok.Setter;
import net.clownercraft.ccRides.API.ride.Ride;
import org.bukkit.event.Cancellable;

/**
 * Fired when a ride starts it's sequence.
 */
@Getter @Setter
public class RideStartEvent extends RideEvent implements Cancellable {
    boolean cancelled = false;
    StartReason startReason;

    public enum StartReason {
        AUTO_START,
        AUTO_START_FULL,
        AUTO_START_EMPTY,
        COMMAND,
        UNKNOWN
    }

    public RideStartEvent(Ride ride, StartReason reason) {
        super(ride);
        this.startReason = reason;
    }

}
