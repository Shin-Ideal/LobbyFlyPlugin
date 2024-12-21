package com.github.Shin_Ideal.LobbyFlyPlugin.CommandExecutors;

import com.github.Shin_Ideal.LobbyFlyPlugin.LobbyFlyPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class FlyManageCommandExecutor implements CommandExecutor {

    private final LobbyFlyPlugin Instance;

    public FlyManageCommandExecutor() {
        Instance = LobbyFlyPlugin.getInstance();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            sendHelp(sender);
            return true;
        } else {
            switch (args[0]) {
                case "help":
                    sendHelp(sender);
                    break;

                case "reload":
                    reload(sender);
                    break;

                default:
                    sendHelp(sender);
                    return false;
            }
        }
        return true;
    }

    private void sendHelp(CommandSender sender) {
        sender.sendMessage("/flymanage <help>");
        sender.sendMessage("/flymanage <reload>");
    }

    private void reload(CommandSender sender) {
        Instance.reloadConfig();
        sender.sendMessage(Instance.getPluginMessagePrefix() + "Config Reloaded!");
    }
}
