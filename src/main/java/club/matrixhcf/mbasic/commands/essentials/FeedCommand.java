package club.matrixhcf.mbasic.commands.essentials;

import club.matrixhcf.mbasic.mBasic;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FeedCommand implements CommandExecutor {
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (sender instanceof Player) {
            if (!sender.hasPermission("mbasic.feed")) {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', mBasic.getInstance().getConfig().getString("no-permission").replace('&', '&')));
                return false;
            }
            Player player = (Player) sender;
            if (args.length < 1) {
                player.getInventory().setArmorContents(null);
                player.getInventory().clear();
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', mBasic.getInstance().getConfig().getString("feed.completed").replace("%player%", player.getDisplayName())));
                return false;
            }
            Player target = Bukkit.getPlayer(args[0]);
            if (args.length >=1) {
                target.setFoodLevel(20);
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', mBasic.getInstance().getConfig().getString("feed.completed").replace("%player%", target.getDisplayName())));
                target.sendMessage(ChatColor.translateAlternateColorCodes('&', mBasic.getInstance().getConfig().getString("feed.fed")));
            }
        }
        return false;
    }
}
