package club.matrixhcf.mbasic.commands.gamemode;


import club.matrixhcf.mbasic.mBasic;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GMACommand implements CommandExecutor {
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (sender instanceof Player) {
            if(!sender.hasPermission("mbasic.gamemode")){
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', mBasic.getInstance().getConfig().getString("no-permission")));
                return false;
            }
            if(args.length < 1) {
                ((Player) sender).setGameMode(GameMode.ADVENTURE);
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', mBasic.getInstance().getConfig().getString("gamemode.updated")));
                return false;
            }
            Player target = Bukkit.getPlayer(args[0]);
            if(args.length >= 1) {
                target.setGameMode(GameMode.ADVENTURE);
                target.sendMessage(ChatColor.translateAlternateColorCodes('&', mBasic.getInstance().getConfig().getString("gamemode.updated")));
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', mBasic.getInstance().getConfig().getString("gamemode.updated-other").replace("%target%", target.getDisplayName())));
                return false;
            }
        }
        return false;
    }
}
