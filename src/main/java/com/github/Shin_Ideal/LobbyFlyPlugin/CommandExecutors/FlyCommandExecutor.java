package com.github.Shin_Ideal.LobbyFlyPlugin.CommandExecutors;

import com.github.Shin_Ideal.LobbyFlyPlugin.LobbyFlyPlugin;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlyCommandExecutor implements CommandExecutor {

    private final LobbyFlyPlugin Instance;

    public FlyCommandExecutor() {
        Instance = LobbyFlyPlugin.getInstance();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return false;
        }
        Player player = (Player) sender;
        player.setAllowFlight(!player.getAllowFlight());
        player.sendMessage(Instance.getPluginMessagePrefix() + "Fly is " + (player.getAllowFlight() ? ChatColor.GREEN + "enable" : ChatColor.RED + "disable"));
        return true;
    }
}
