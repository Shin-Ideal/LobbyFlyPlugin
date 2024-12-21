package com.github.Shin_Ideal.LobbyFlyPlugin.Listeners;

import com.github.Shin_Ideal.LobbyFlyPlugin.LobbyFlyPlugin;
import org.bukkit.configuration.Configuration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class BackFromVoidListener implements Listener {

    private final LobbyFlyPlugin Instance;
    private final Configuration config;

    public BackFromVoidListener() {
        Instance = LobbyFlyPlugin.getInstance();
        config = Instance.getConfig();
    }

    @EventHandler
    public void onDamage(EntityDamageEvent event) {
        if (!config.getBoolean("back-from-void.enable")) {
            return;
        }

        if (!(event.getEntity() instanceof Player)) {
            return;
        }
        if (!event.getCause().equals(EntityDamageEvent.DamageCause.VOID)) {
            return;
        }
        Player player = (Player) event.getEntity();
        player.teleport(player.getWorld().getSpawnLocation().add(
                config.getDouble("join-tp-spawn.add-x")
                , config.getDouble("join-tp-spawn.add-y")
                , config.getDouble("join-tp-spawn.add-z")
        ));
        event.setCancelled(true);
    }
}
