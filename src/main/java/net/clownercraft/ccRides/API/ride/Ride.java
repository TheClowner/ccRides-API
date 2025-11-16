package net.clownercraft.ccRides.API.ride;

import net.clownercraft.ccRides.API.events.RideEnterEvent;
import net.clownercraft.ccRides.API.events.RideExitEvent;
import net.clownercraft.ccRides.API.events.RideStartEvent;
import net.clownercraft.ccRides.API.events.RideStopEvent;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.List;

/**
 * Represents a single Ride
 */
public interface Ride {

    /**
     * @return this ride's Name / ID
     */
    String getName();

    /**
     * @return a string representing the ride type
     */
    String getType();

    /**
     * @return an ArrayList containing the players currently on the ride.
     */
    List<Player> getRiders();

    /**
     * Find which seat a rider is in
     * Will throw an IllegalArgumentException if player is not on ride
     * @param player the player whose seat you want to find
     * @return the index of the seat (counts from 0)
     */
    int getRiderSeat(Player player);

    /**
     * @return an ArrayList containing the names of all ride settings
     */
    List<String> getConfigOptions();

    /**
     *
     * @return a map containing all ride settings and their type
     */
    HashMap<String, Class<?>> getConfigOptionTypes();

    /**
     * Get the value of a ride setting
     *
     * @param key the name of the setting
     * @return the current value of the setting
     */
    Object getRideSetting(String key);

    /**
     * Set a ride's setting
     * @param key the name of the setting
     * @param value the new value for the setting
     * @throws IllegalArgumentException if value is not correct type for given key
     * @throws IndexOutOfBoundsException if the key does not exist
     */
    void setRideSetting(String key, Object value);

    /**
     * Enable the ride
     * @return true if enabled successfully, false if encountered an issue.
     */
    boolean enable();

    /**
     * Disable the ride
     */
    void disable();

    /**
     * Starts the movement of a ride
     */
    void startRide(RideStartEvent.StartReason startReason);

    /**
     * Stop a ride (immediately), and kicks players out
     */
    void stopRide(RideStopEvent.RideStopReason stopReason);

    /**
     * Finds the first available seat on the ride
     * @return the index of the seat, -1 if the ride is full
     */
    int firstAvailableSeat();

    /**
     * Add a new player to the ride
     * Adds to the ride queue if the ride is full (still returns true)
     * @param player the player to add
     * @param bypassCost whether to ignore the price
     * @param seatNumber the seat index to add the player true
     * @param enterMethod the method used to join the ride
     * @return true if successful, false if failed (i.e. seat taken, not enough money, no permissions)
     */
    boolean addPlayer(Player player, boolean bypassCost, int seatNumber, RideEnterEvent.EnterMethod enterMethod);

    /**
     * Add a new player to the ride, putting them in the first available seat
     * @param player the player to add
     * @param bypassCost whether to ignore the price
     * @return true if successful, false if failed
     */
    default boolean addPlayer(Player player, boolean bypassCost,RideEnterEvent.EnterMethod enterMethod) {
        return addPlayer(player,bypassCost,firstAvailableSeat(),enterMethod);
    }

    /**
     * Add a new player to the ride, putting them in the first available seat
     * Ride price, permissions will be checked
     * @param player the player to add
     * @return true if successful, false if failed
     */
    default boolean addPlayer(Player player) {
        return addPlayer(player,false,firstAvailableSeat(), RideEnterEvent.EnterMethod.OTHER);
    }

    /**
     * Remove a player from the ride (forcefully)
     * Uses the ride's EXIT_TELEPORT_RUNNING option to determine whether to teleport or eject the player at their seat
     * @param player the player to eject
     * @param reason the reason for exiting (ie. Command / Ride end etc)
     */
    void ejectPlayer(Player player, RideExitEvent.ExitReason reason);

    /**
     * @return whether this ride is currently enabled.
     */
    boolean isEnabled();

    /**
     * @return whether the ride is currently running (i.e. moving)
     */
    boolean isRunning();

    /**
     * @return whether the ride's countdown (for automatically starting) has begun
     */
    boolean isCountdownStarted();

    /**
     * @return how long is left on the ride's countdown timer. -1 if countdown hasn't started
     */
    int getRemainingCountdownTime();
}
