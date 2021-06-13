package club.matrixhcf.mbasic.commands.essentials;

import club.matrixhcf.mbasic.mBasic;
import club.matrixhcf.mbasic.util.CC;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class PingCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        Player player = (Player) sender;



        if (!(args.length == 1)) {

            int playerping = ((CraftPlayer) player).getHandle().ping;
            player.sendMessage(CC.translate(mBasic.getInstance().getConfig().getString("ping.ping-your").replace("%ping%", String.valueOf(playerping))));
        }

        else if (args.length == 1)
        {


            Player target = Bukkit.getPlayer(args[0]);
            int targetPing = ((CraftPlayer) target).getHandle().ping;
            String targetName = target.getName();
            player.sendMessage(CC.translate(mBasic.getInstance().getConfig().getString("ping.ping-message").replace("%ping%", String.valueOf(targetPing)).replace("%target%", targetName)));
        }

        return false;
    }
}
