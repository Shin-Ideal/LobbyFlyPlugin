package com.github.Shin_Ideal.LobbyFlyPlugin;

import org.bukkit.configuration.Configuration;

public class ConfigManager {

    private static Configuration config;

    public static void Init(){
        LobbyFlyPlugin plugin = LobbyFlyPlugin.getPlugin();
        plugin.saveDefaultConfig();
        config=plugin.getConfig();
    }

    public static Configuration getConfig(){
        return config;
    }

    public static void reload() {
        LobbyFlyPlugin plugin = LobbyFlyPlugin.getPlugin();
        plugin.reloadConfig();
        config=plugin.getConfig();
    }

}
