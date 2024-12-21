package com.github.Shin_Ideal.LobbyFlyPlugin.Listeners;

import com.github.Shin_Ideal.LobbyFlyPlugin.LobbyFlyPlugin;
import org.bukkit.configuration.Configuration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class JoinFlyListener implements Listener {

    private final LobbyFlyPlugin Instance;
    private final Configuration config;

    public JoinFlyListener() {
        Instance = LobbyFlyPlugin.getInstance();
        config = Instance.getConfig();
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        if (!config.getBoolean("join-fly.enable")) {
            return;
        }

        Player player = event.getPlayer();
        if (player.hasPermission("lobbyflyplugin.fly")) {
            player.setAllowFlight(true);
            player.setFlying(true);
            new BukkitRunnable() {
                @Override
                public void run() {
                    double add_y_location = config.getDouble("join-fly.add-y-location");
                    if (add_y_location != 0) {
                        player.teleport(player.getLocation().add(0, add_y_location, 0));
                    }
                }
            }.runTaskLater(Instance, 5L);
        }
    }
}
