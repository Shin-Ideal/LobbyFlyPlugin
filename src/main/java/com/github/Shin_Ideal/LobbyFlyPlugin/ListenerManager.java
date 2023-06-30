package com.github.Shin_Ideal.LobbyFlyPlugin;

import com.github.Shin_Ideal.LobbyFlyPlugin.Listeners.*;
import org.bukkit.configuration.Configuration;
import org.bukkit.event.HandlerList;

public class ListenerManager {

    public static void Init(){
        UpdateListener();
    }

    public static void Fina(){
        HandlerList.unregisterAll();
    }

    private static void UpdateListener(){
        LobbyFlyPlugin plugin = LobbyFlyPlugin.getPlugin();
        Configuration config = ConfigManager.getConfig();

        HandlerList.unregisterAll();

        if(config.getBoolean("join-fly.enable")){
            plugin.getServer().getPluginManager().registerEvents(new Join_Fly_Listener(),plugin);
            Join_Fly_Listener.setAdd_y_location(config.getDouble("join-fly.add-y-location"));
        }

        if(config.getBoolean("disable-fall-damage.enable")){
            plugin.getServer().getPluginManager().registerEvents(new Disable_Fall_Damage_Listener(),plugin);
        }

        if(config.getBoolean("disable-all-damage.enable")){
            plugin.getServer().getPluginManager().registerEvents(new Disable_All_Damage_Listener(),plugin);
        }

        if(config.getBoolean("join-tp-spawn.enable")){
            plugin.getServer().getPluginManager().registerEvents(new Join_Tp_Spawn_Listener(),plugin);
            Join_Tp_Spawn_Listener.setXYZ(
                    config.getDouble("join-tp-spawn.add-x"),
                    config.getDouble("join-tp-spawn.add-y"),
                    config.getDouble("join-tp-spawn.add-z")
            );
        }

        if(config.getBoolean("horizon-limit.enable")){
            plugin.getServer().getPluginManager().registerEvents(new Horizon_Limit_Listener(),plugin);
            Horizon_Limit_Listener.setDistance(
                    config.getDouble("horizon-limit.x-min-distance"),
                    config.getDouble("horizon-limit.x-max-distance"),
                    config.getDouble("horizon-limit.z-min-distance"),
                    config.getDouble("horizon-limit.z-max-distance")
            );
        }

        if(config.getBoolean("back-from-void.enable")){
            plugin.getServer().getPluginManager().registerEvents(new Back_From_Void_Listener(),plugin);
            Back_From_Void_Listener.setXYZ(
                    config.getDouble("join-tp-spawn.add-x"),
                    config.getDouble("join-tp-spawn.add-y"),
                    config.getDouble("join-tp-spawn.add-z")
            );
        }
    }

    public static void reload() {
        UpdateListener();
    }

}
