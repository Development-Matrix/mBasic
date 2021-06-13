package club.matrixhcf.mbasic.commands.essentials;

import club.matrixhcf.mbasic.mBasic;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TeleportCommand implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (!sender.hasPermission("mbasic.teleport")) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', mBasic.getInstance().getConfig().getString("no-permission").replace('&', '&')));
            return false;
        }
        Player player = (Player) sender;
        if (args.length < 1) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', mBasic.getInstance().getConfig().getString("tp.usage")));
            return false;
        }
        Player target = Bukkit.getPlayer(args[0]);
        if (args.length >=1) {
            player.teleport(target.getLocation());
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', mBasic.getInstance().getConfig().getString("tp.completed").replace("%player%", target.getDisplayName())));
        }

        return false;
    }
}
