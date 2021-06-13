package club.matrixhcf.mbasic.commands.message;

import club.matrixhcf.mbasic.mBasic;
import club.matrixhcf.mbasic.util.CC;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReplyCommand implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        Player messager = (Player) sender;
        if(mBasic.getInstance().messageManager.getReply(messager) == null){
            messager.sendMessage(CC.translate(mBasic.getInstance().getConfig().getString("message.not-conversation")));
            return true;
        }

        if(mBasic.getInstance().messageManager.isTogglepm(messager) == true){
            messager.sendMessage(CC.translate(mBasic.getInstance().getConfig().getString("message.togglepm-you")));
            return true;
        }
        Player target = mBasic.getInstance().messageManager.getReply(messager);
        if(mBasic.getInstance().messageManager.isTogglepm(target) == true){
            messager.sendMessage(CC.translate(mBasic.getInstance().getConfig().getString("message.togglepm-user")));
            return true;
        }

        if(args.length < 1){
            sender.sendMessage(CC.translate(mBasic.getInstance().getConfig().getString("message.replying-to").replace("%target%", target.getDisplayName())));
            return true;
        }
        String message = "";
        for(int i = 0; i < args.length; i++){
            message += "" + args[i];
        }


        messager.sendMessage(CC.translate(mBasic.getInstance().getConfig().getString("message.to-format").replace("%player%", messager.getDisplayName()).replace("%msg%", message).replaceAll("%target%", target.getDisplayName())));
        target.sendMessage(CC.translate(mBasic.getInstance().getConfig().getString("message.from-format").replace("%player%", target.getDisplayName()).replace("%msg%", message).replaceAll("%target%", messager.getDisplayName())));
        return false;
    }
}
