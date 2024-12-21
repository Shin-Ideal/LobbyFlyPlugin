package com.github.Shin_Ideal.LobbyFlyPlugin;

import com.github.Shin_Ideal.LobbyFlyPlugin.CommandExecutors.FlyCommandExecutor;
import com.github.Shin_Ideal.LobbyFlyPlugin.CommandExecutors.FlyManageCommandExecutor;
import com.github.Shin_Ideal.LobbyFlyPlugin.Listeners.*;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class LobbyFlyPlugin extends JavaPlugin {

    private static LobbyFlyPlugin Instance;
    private String pluginMessagePrefix;

    @Override
    public void onEnable() {
        Instance = this;
        pluginMessagePrefix = ChatColor.GOLD + "[LobbyFly] " + ChatColor.RESET;

        saveDefaultConfig();
        registerListeners();

        getCommand("fly").setExecutor(new FlyCommandExecutor());
        getCommand("flymanage").setExecutor(new FlyManageCommandExecutor());

        getLogger().info("Enable");
    }

    @Override
    public void onDisable() {
        getLogger().info("Disable");
    }

    public static LobbyFlyPlugin getInstance() {
        return Instance;
    }

    @Deprecated
    public static LobbyFlyPlugin getPlugin() {
        return Instance;
    }

    public String getPluginMessagePrefix() {
        return pluginMessagePrefix;
    }

    private void registerListeners() {
        getServer().getPluginManager().registerEvents(new JoinTpSpawnListener(), this);
        getServer().getPluginManager().registerEvents(new JoinFlyListener(), this);
        getServer().getPluginManager().registerEvents(new DisableFallDamageListener(), this);
        getServer().getPluginManager().registerEvents(new DisableAllDamageListener(), this);
        getServer().getPluginManager().registerEvents(new HorizonLimitListener(), this);
        getServer().getPluginManager().registerEvents(new BackFromVoidListener(), this);
    }
}
