package de.maifii.skywarsffa.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;

public class WeatherChangeListener implements Listener {

    @EventHandler
    public void onWeatherChange(WeatherChangeEvent event) {
        if (event.getCause().equals(WeatherChangeEvent.Cause.NATURAL)) {
            event.setCancelled(true);
        }
    }
}
