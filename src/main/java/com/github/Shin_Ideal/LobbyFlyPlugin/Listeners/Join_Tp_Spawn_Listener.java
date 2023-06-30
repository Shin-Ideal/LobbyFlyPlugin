package com.github.Shin_Ideal.LobbyFlyPlugin.Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Join_Tp_Spawn_Listener implements Listener {

    private static double x,y,z;

    public static void setXYZ(double addx,double addy,double addz) {
        x = addx;
        y = addy;
        z = addz;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();

        player.teleport(player.getWorld().getSpawnLocation().add(x,y,z));
    }

}
