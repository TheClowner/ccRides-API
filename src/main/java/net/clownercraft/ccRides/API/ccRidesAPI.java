package net.clownercraft.ccRides.API;

import net.clownercraft.ccRides.API.ride.Ride;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.plugin.Plugin;

import java.util.HashMap;

/**
 * Main class to access the ccRides API
 */
public interface ccRidesAPI {
    String API_VERSION = "BETA-0.2";

    /**
     * Get the API instance
     * Returns null if ccRides not installed / using older versions
     * @return an instance of the plugin, or null if it was not found
     */
    static ccRidesAPI getAPI() {
        Plugin plug = Bukkit.getPluginManager().getPlugin("ccRides");
        if (plug instanceof ccRidesAPI) {
            return (ccRidesAPI) plug;
        } else return null;
    }

    /**
     * Checks the API version of the plugin
     * @return the plugin version string
     */
    String getAPIVersion();

    /**
     * Get all configured rides
     * @return a map of all rides (RideID, Ride)
     */
    HashMap<String, Ride> getRides();

    /**
     * Get a specific ride
     * @param name - the name/ID of the ride to get
     * @return the requested ride
     */
    Ride getRide(String name);

    /**
     * Get a player's fastpass balance
     * @param player player whose balance to check
     * @return number of fastpasses they currently have, 0 if feature disabled, -1 if they have the unlimited permission
     */
    int getFastPasses(OfflinePlayer player);

    /**
     * Set a player's fastpass balance
     * Fails silently if fastpasses are disabled in ccRides
     * @param player player whose balance to change
     * @param amount new fastpass balance
     */
    void setFastPasses(OfflinePlayer player, int amount);

}
