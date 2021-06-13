package club.matrixhcf.mbasic.commands.essentials;

import club.matrixhcf.mbasic.mBasic;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import javax.swing.text.AttributeSet;

public class RawCommand implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;
        if (!player.hasPermission("mbasic.raw")) {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', mBasic.getInstance().getConfig().getString("no-permission")));
            return false;
        }
        if (args.length >= 1) {
            String message = "";
            for (int i = 0; i < args.length; i++)
                message = String.valueOf(message) + args[i] + " ";
            for (Player all : Bukkit.getServer().getOnlinePlayers()) {
                Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', message));
            }
        }
        return false;
    }
}
