package club.matrixhcf.mbasic.commands.message;

import club.matrixhcf.mbasic.mBasic;
import club.matrixhcf.mbasic.util.CC;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import sun.applet.Main;

public class MessageCommands implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(args.length > 0){
            if(Bukkit.getOfflinePlayer(args[0]).getPlayer() != null){
                Player messager = (Player) sender;
                Player target = Bukkit.getOfflinePlayer(args[0]).getPlayer();
                mBasic.getInstance().messageManager.setReply(messager, target);
                args[0] = "";
                String message = "";
                for(int i = 0; i < args.length; i++){
                    message += "" + args[i];
                }
                if(mBasic.getInstance().messageManager.isTogglepm(messager) == true){
                    messager.sendMessage(CC.translate(mBasic.getInstance().getConfig().getString("message.togglepm-you")));
                    return true;
                }
                if(mBasic.getInstance().messageManager.isTogglepm(target) == true){
                    messager.sendMessage(CC.translate(mBasic.getInstance().getConfig().getString("message.togglepm-user")));
                    return true;
                }

                messager.sendMessage(CC.translate(mBasic.getInstance().getConfig().getString("message.to-format").replace("%player%", messager.getDisplayName()).replace("%msg%", message).replaceAll("%target%", target.getDisplayName())));
                target.sendMessage(CC.translate(mBasic.getInstance().getConfig().getString("message.from-format").replace("%player%", target.getDisplayName()).replace("%msg%", message).replaceAll("%target%", messager.getDisplayName())));
            } else {
                sender.sendMessage(CC.translate(mBasic.getInstance().getConfig().getString("offline")));
            }
            return true;


        } else {
            sender.sendMessage(CC.translate(mBasic.getInstance().getConfig().getString("message.usage")));
        }
        return false;
    }
}
