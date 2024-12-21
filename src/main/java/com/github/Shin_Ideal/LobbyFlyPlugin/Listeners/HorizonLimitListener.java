package com.github.Shin_Ideal.LobbyFlyPlugin.Listeners;

import com.github.Shin_Ideal.LobbyFlyPlugin.LobbyFlyPlugin;
import org.bukkit.configuration.Configuration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

public class HorizonLimitListener implements Listener {

    private final LobbyFlyPlugin Instance;
    private final Configuration config;

    public HorizonLimitListener() {
        Instance = LobbyFlyPlugin.getInstance();
        config = Instance.getConfig();
    }

    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        if (!config.getBoolean("horizon-limit.enable")) {
            return;
        }

        Player player = event.getPlayer();
        Vector player_vector = player.getVelocity();
        double x = player.getLocation().getX();
        double z = player.getLocation().getZ();

        double x_min_distance = config.getDouble("horizon-limit.x-min-distance");
        double x_max_distance = config.getDouble("horizon-limit.x-max-distance");
        double z_min_distance = config.getDouble("horizon-limit.z-min-distance");
        double z_max_distance = config.getDouble("horizon-limit.z-max-distance");

        if (x < x_min_distance) {
            player.setVelocity(player_vector.add(new Vector(1, 0, 0)));
        }
        if (x_max_distance < x) {
            player.setVelocity(player_vector.add(new Vector(-1, 0, 0)));
        }
        if (z < z_min_distance) {
            player.setVelocity(player_vector.add(new Vector(0, 0, 1)));
        }
        if (z_max_distance < z) {
            player.setVelocity(player_vector.add(new Vector(0, 0, -1)));
        }
    }
}
