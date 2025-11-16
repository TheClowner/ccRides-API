package net.clownercraft.ccRides.API.events;

import lombok.Getter;
import lombok.Setter;
import net.clownercraft.ccRides.API.ride.Ride;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;

/**
 * Event representing a player Entering a ride.
 */
@Getter @Setter
public class RideEnterEvent extends RidePlayerEvent implements Cancellable {
    EnterMethod enterMethod;
    boolean cancelled = false;

    public enum EnterMethod {
        SIGN_CLICK,
        SEAT_CLICK,
        COMMAND,
        FORCE_COMMAND,
        QUEUE,
        OTHER
    }

    public RideEnterEvent(Ride ride, Player rider, EnterMethod enterMethod) {
        super(ride, rider);
        this.enterMethod = enterMethod;
    }
}
