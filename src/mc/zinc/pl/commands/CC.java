package mc.zinc.pl.commands;

import mc.zinc.pl.Simple;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class CC implements CommandExecutor
{
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        String pl_name = ChatColor.translateAlternateColorCodes('&', "&7[&bZinc&7]&a ");

        if (sender instanceof Player player)
        {
            if (player.isOp() || Simple.is_vip(player.getName()))
            {
                if (args.length != 0)
                {
                    Simple.set_cc(player.getName(), args[0]);
                    player.sendMessage(pl_name + "Your new chat color is " + Simple.get_cc(player.getName()) + "█");
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
