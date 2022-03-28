package mc.zinc.pl.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class ChatClear implements CommandExecutor
{
    String pl_name = ChatColor.translateAlternateColorCodes('&', "&7[&bZinc&7]&a ");

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        if (sender instanceof Player player)
        {
            if (player.isOp())
            {
                // Bukkit.broadcastMessage(" ");
                for (Player p : Bukkit.getOnlinePlayers())
                { for (int i = 0; i < 100; i++) p.sendMessage(""); }

                Bukkit.broadcastMessage(pl_name + player.getDisplayName() + " sohbeti temizledi.");
            }
            else player.sendMessage(ChatColor.translateAlternateColorCodes('&', pl_name + "&cYou don't have permission for this command!"));
        }
        else
        {
            ConsoleCommandSender console = Bukkit.getConsoleSender();
            console.sendMessage(ChatColor.translateAlternateColorCodes('&', pl_name + "&cYou can't use this on terminal."));
        }
        return true;
    }
}
