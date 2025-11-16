package net.clownercraft.ccRides.API.events;

import lombok.Getter;
import lombok.Setter;
import net.clownercraft.ccRides.API.ride.Ride;
import org.bukkit.entity.Player;

/**
 * Represents any event involving a ride and a player.
 * Eg. entering, exiting a ride
 */
@Getter @Setter
public class RidePlayerEvent extends RideEvent {
    /**
     * The player (rider) who triggered the event
     */
    Player rider;

    public RidePlayerEvent(Ride ride, Player rider) {
        super(ride);
        this.rider = rider;
    }
}
