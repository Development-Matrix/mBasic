package club.matrixhcf.mbasic.managers;

import club.matrixhcf.mbasic.mBasic;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class MessageManager {

    HashMap<Player, Player> messages = new HashMap<Player, Player>();

    public MessageManager(mBasic mBasic) {

    }

    public void setReply(Player messager, Player received){
        messages.put(messager, received);
        messages.put(received, messager);
    }

    public Player getReply(Player messager){
        return messages.get(messager);
    }
    public boolean togglepm;

    public boolean isTogglepm(Player messager) {
        return togglepm;
    }

    public void setTogglepm(boolean togglepm, Player messager) {
        this.togglepm = togglepm;

    }

}
