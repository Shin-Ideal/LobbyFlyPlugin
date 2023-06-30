package com.github.Shin_Ideal.LobbyFlyPlugin.Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class Back_From_Void_Listener implements Listener {

    private static double x,y,z;

    public static void setXYZ(double addx,double addy,double addz) {
        x = addx;
        y = addy;
        z = addz;
    }

    @EventHandler
    public void onDamage(EntityDamageEvent event){
        if(!(event.getEntity() instanceof Player)){
            return;
        }
        if(!event.getCause().equals(EntityDamageEvent.DamageCause.VOID)){
            return;
        }
        Player player = ((Player) event.getEntity()).getPlayer();

        player.teleport(player.getWorld().getSpawnLocation().add(x,y,z));
        event.setCancelled(true);
    }

}
