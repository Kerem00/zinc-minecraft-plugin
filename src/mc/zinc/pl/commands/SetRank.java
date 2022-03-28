package mc.zinc.pl.commands;

import mc.zinc.pl.Simple;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class SetRank implements CommandExecutor
{
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        String pl_name = ChatColor.translateAlternateColorCodes('&', "&7[&bZinc&7]&a ");

        if (sender instanceof Player player)
        {
            if (player.isOp())
            {
                if (args.length == 2)
                {
                    Simple.set_vip(args[0], args[1].equals("vip"));
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', pl_name + args[0] + " is now " + args[1] + "."));
                }
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
