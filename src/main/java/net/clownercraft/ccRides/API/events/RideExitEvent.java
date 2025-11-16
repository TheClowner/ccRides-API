package net.clownercraft.ccRides.API.events;

import lombok.Getter;
import lombok.Setter;
import net.clownercraft.ccRides.API.ride.Ride;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;

@Getter @Setter
public class RideExitEvent extends RidePlayerEvent implements Cancellable {
    ExitReason exitReason;
    boolean cancelled = false;

    public enum ExitReason {
        SEAT_EXIT,
        RIDE_STOP,
        LOGOUT,
        DEATH,
        COMMAND,
        FORCE_COMMAND,
        UNKNOWN
    }

    public RideExitEvent(Ride ride, Player rider, ExitReason reason) {
        super(ride, rider);
        this.exitReason = reason;
    }
}
