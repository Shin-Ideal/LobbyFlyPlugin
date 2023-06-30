package com.github.Shin_Ideal.LobbyFlyPlugin;

import com.github.Shin_Ideal.LobbyFlyPlugin.CommandExecutors.Fly;
import com.github.Shin_Ideal.LobbyFlyPlugin.CommandExecutors.FlyManage;
import org.bukkit.plugin.java.JavaPlugin;

public class LobbyFlyPlugin extends JavaPlugin {

    private static LobbyFlyPlugin thisPlugin;

    @Override
    public void onEnable(){
        getLogger().info("Enable");
        thisPlugin=this;
        ConfigManager.Init();
        ListenerManager.Init();

        getCommand("fly").setExecutor(new Fly());
        getCommand("flymanage").setExecutor(new FlyManage());
    }

    @Override
    public void onDisable(){
        ListenerManager.Fina();
        getLogger().info("Disable");
    }

    public static LobbyFlyPlugin getPlugin() {
        return thisPlugin;
    }

}
