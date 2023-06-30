package com.github.Shin_Ideal.LobbyFlyPlugin.Listeners;

import com.github.Shin_Ideal.LobbyFlyPlugin.LobbyFlyPlugin;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class Join_Fly_Listener implements Listener {

    private static double add_y_location;

    public static void setAdd_y_location(double add_y_location) {
        Join_Fly_Listener.add_y_location = add_y_location;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        LobbyFlyPlugin plugin = LobbyFlyPlugin.getPlugin();
        Player player = event.getPlayer();

        if(player.hasPermission("lobbyflyplugin.fly")){
            player.setAllowFlight(true);
            player.setFlying(true);
            new BukkitRunnable(){
                @Override
                public void run(){
                    if(add_y_location!=0) {
                        player.teleport(player.getLocation().add(0, add_y_location, 0));
                    }
                }
            }.runTaskLater(plugin,5L);
        }
    }

}
