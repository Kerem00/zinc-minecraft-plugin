package mc.zinc.pl;


import mc.zinc.pl.commands.ChatClear;
import mc.zinc.pl.commands.Heal;
import mc.zinc.pl.events.JoinLeaveListener;
import mc.zinc.pl.events.PlayerDeathListener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class Main extends JavaPlugin
{
    String pl_name = ChatColor.translateAlternateColorCodes('&', "&7[&bZinc&7]&a ");

    public void onEnable()
    {
        File dir = new File("plugins/Zinc");
        if (!dir.exists()) dir.mkdir();

        ConsoleCommandSender console = Bukkit.getConsoleSender();
        console.sendMessage(pl_name + "Loading...");
        PluginManager pm = Bukkit.getPluginManager();

        this.getCommand("heal").setExecutor(new Heal());
        this.getCommand("clearchat").setExecutor(new ChatClear());

        pm.registerEvents(new JoinLeaveListener(), this);
        pm.registerEvents(new PlayerDeathListener(), this);

        console.sendMessage(pl_name + "Enabled.");
    }

    public void onDisable()
    {
        ConsoleCommandSender console = Bukkit.getConsoleSender();
        console.sendMessage(pl_name + "Disabled.");
    }
}
