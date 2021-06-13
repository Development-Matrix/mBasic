package club.matrixhcf.mbasic;

import club.matrixhcf.mbasic.commands.*;
import club.matrixhcf.mbasic.commands.essentials.*;
import club.matrixhcf.mbasic.commands.gamemode.GMACommand;
import club.matrixhcf.mbasic.commands.gamemode.GMCCommand;
import club.matrixhcf.mbasic.commands.gamemode.GMSCommand;
import club.matrixhcf.mbasic.commands.gamemode.GMSPCommand;
import club.matrixhcf.mbasic.commands.message.MessageCommands;
import club.matrixhcf.mbasic.commands.message.ReplyCommand;
import club.matrixhcf.mbasic.commands.message.TogglePMCommand;
import club.matrixhcf.mbasic.managers.MessageManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class mBasic extends JavaPlugin {

    public static mBasic getInstance() { return  mBasic.instance; }
    public static mBasic instance;

    public MessageManager messageManager;

    public void onEnable(){
        instance = this;
        this.saveDefaultConfig();
        Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "Thank you for using mBasic");
        Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "Please join our support discord if you encounter any problems");
        Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "https://discord.gg/wgNNQnPqW6");
        registerCommands();
        registerManagers();
        registerListeners();

    }

    public void onDisable(){
        Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "mBasic DISABLED!");
        Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "Join out support discord!");
        Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "https://discord.gg/wgNNQnPqW6");
    }

    public void registerCommands(){

        getCommand("feed").setExecutor(new FeedCommand());
        getCommand("heal").setExecutor(new HealCommand());
        getCommand("gmc").setExecutor(new GMCCommand());
        getCommand("gms").setExecutor(new GMSCommand());
        getCommand("gmsp").setExecutor(new GMSPCommand());
        getCommand("gma").setExecutor(new GMACommand());
        getCommand("clear").setExecutor(new ClearCommand());
        getCommand("mbasic").setExecutor(new mBasicCommand());
        getCommand("raw").setExecutor(new RawCommand());
        getCommand("msg").setExecutor(new MessageCommands());
        getCommand("tp").setExecutor(new TeleportCommand());
        getCommand("reply").setExecutor(new ReplyCommand());
        getCommand("togglepm").setExecutor(new TogglePMCommand());
        getCommand("ping").setExecutor(new PingCommand());
    }

    public void registerManagers(){
        messageManager = new MessageManager(this);
    }

    public void registerListeners(){
        final PluginManager pm = Bukkit.getPluginManager();
    }

}
