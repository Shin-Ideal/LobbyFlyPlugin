package com.github.Shin_Ideal.LobbyFlyPlugin.Listeners;

import com.github.Shin_Ideal.LobbyFlyPlugin.LobbyFlyPlugin;
import org.bukkit.configuration.Configuration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class DisableFallDamageListener implements Listener {

    private final LobbyFlyPlugin Instance;
    private final Configuration config;

    public DisableFallDamageListener() {
        Instance = LobbyFlyPlugin.getInstance();
        config = Instance.getConfig();
    }

    @EventHandler
    public void onDamage(EntityDamageEvent event) {
        if (!config.getBoolean("disable-fall-damage.enable")) {
            return;
        }

        if (!(event.getEntity() instanceof Player)) {
            return;
        }
        if (!event.getCause().equals(EntityDamageEvent.DamageCause.FALL)) {
            return;
        }

        event.setCancelled(true);
    }
}
