package net.clownercraft.ccRides.API.events;

import lombok.Getter;
import lombok.Setter;
import net.clownercraft.ccRides.API.ride.Ride;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * Represents a generic Ride Event
 */
@Getter @Setter
public class RideEvent extends Event {
    private static final HandlerList HANDLERS = new HandlerList();

    /** The ride which triggered this event */
    Ride ride;

    public RideEvent(Ride ride) {
        this.ride = ride;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }
}
