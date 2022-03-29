package mc.zinc.pl.commands;

import mc.zinc.pl.Simple;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class Fly implements CommandExecutor
{
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        String pl_name = ChatColor.translateAlternateColorCodes('&', "&7[&bZinc&7]&a ");

        if (sender instanceof Player player)
        {
            if (player.isOp() || Simple.is_vip(player.getName()))
            {
                player.sendMessage(pl_name + ((!player.getAllowFlight()) ? ChatColor.GREEN + "Fly ON" : ChatColor.RED + "Fly OFF"));
                player.setAllowFlight(!player.getAllowFlight());
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
