package com.github.Shin_Ideal.LobbyFlyPlugin.Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class Disable_Fall_Damage_Listener implements Listener {

    @EventHandler
    public void onDamage(EntityDamageEvent event){
        if(!(event.getEntity() instanceof Player)){
            return;
        }
        if(!event.getCause().equals(EntityDamageEvent.DamageCause.FALL)){
            return;
        }
        event.setCancelled(true);
    }

}
