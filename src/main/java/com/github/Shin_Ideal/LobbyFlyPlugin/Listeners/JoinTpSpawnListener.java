package com.github.Shin_Ideal.LobbyFlyPlugin.Listeners;

import com.github.Shin_Ideal.LobbyFlyPlugin.LobbyFlyPlugin;
import org.bukkit.configuration.Configuration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinTpSpawnListener implements Listener {

    private final LobbyFlyPlugin Instance;
    private final Configuration config;

    public JoinTpSpawnListener() {
        Instance = LobbyFlyPlugin.getInstance();
        config = Instance.getConfig();
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        if (!config.getBoolean("join-tp-spawn.enable")) {
            return;
        }

        Player player = event.getPlayer();
        player.teleport(player.getWorld().getSpawnLocation().add(
                config.getDouble("join-tp-spawn.add-x")
                , config.getDouble("join-tp-spawn.add-y")
                , config.getDouble("join-tp-spawn.add-z")
        ));
    }
}
