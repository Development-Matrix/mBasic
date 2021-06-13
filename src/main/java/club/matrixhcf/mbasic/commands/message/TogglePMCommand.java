package club.matrixhcf.mbasic.commands.message;

import club.matrixhcf.mbasic.mBasic;
import club.matrixhcf.mbasic.managers.MessageManager;
import club.matrixhcf.mbasic.util.CC;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TogglePMCommand implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        Player player = (Player) sender;
        if(mBasic.getInstance().messageManager.isTogglepm(player) == true){
            player.sendMessage(CC.translate(mBasic.getInstance().getConfig().getString("message.togglepm-disable")));
            mBasic.getInstance().messageManager.setTogglepm(false, player);
        } else {
            player.sendMessage(CC.translate(mBasic.getInstance().getConfig().getString("message.togglepm-enable")));
            mBasic.getInstance().messageManager.setTogglepm(true, player);
        }
        return false;
    }
}
