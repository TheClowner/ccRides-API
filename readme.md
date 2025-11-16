# ccRides Developer API

ccRides implements a basic developer API that allows you to interact with the rides.   

[Full JavaDocs](https://docs.clownercraft.net/ccRides-API/)   

It is expected that this API will be expanded and added to in the future,   
please let me know any specific requests you have on the [support discord](https://discord.gg/zr5jStNQAn).

There are two main ways to interact with the API:
- Getting an instance of the `ccRidesAPI` class
- Through events

## Adding ccRides to your project

You can add the API to your project as a Maven repo with [jitpack.io](https://jitpack.io/#TheClowner/ccRides-API/1.0)

```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```

```xml
<dependencies>
    <dependency>
        <groupId>com.github.TheClowner</groupId>
        <artifactId>ccRides-API</artifactId>
        <version>BETA-0.2</version>
        <scope>provided</scope>
    </dependency>
</dependencies>
```
Don't forget to add `ccRides` as a dependency in your plugin.yml!

## Getting the API class

The ccRidesAPI class offers methods to get ride objects, or fastpass balances.

To get the ccRidesAPI class, use the static method `ccRidesAPI.getApi()`
> NB: This method returns null if you don't have the ccRides plugin installed/running (or an older version of it)

You can then use `getApiVersion()` to verify the plugin is running a matching API version.   
The latest API version is currently `BETA-0.2` 

## Events
ccRides includes 5 main events:
> You can listen for these events the same as with any bukkit event
- **RideEnterEvent** - Called when a player gets onto a ride.
- **RideExitEvent** - Called when a player exits a ride.
- **RideCountdownStartEvent** - Called when a ride triggers it's automatic start countdown (ie. once there are enough players)
- **RideStartEvent** - Called when a ride starts running
- **RideStopEvent** - Called when a ride stops (for any reason)