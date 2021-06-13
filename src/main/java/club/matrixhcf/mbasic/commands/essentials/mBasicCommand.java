

package club.matrixhcf.mbasic.commands.essentials;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class mBasicCommand implements CommandExecutor {


    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (sender instanceof Player) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7&m------------------------------------"));
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&emBasic made by &6Matrix Development&b&e!"));
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&eMC-Market username&7: &6Fleshyyy"));
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&eVersion&7: &6v1.0"));
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7&m------------------------------------"));
        }

        return false;
    }
}
