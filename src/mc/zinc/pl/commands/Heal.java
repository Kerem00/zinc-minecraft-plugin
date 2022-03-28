package mc.zinc.pl.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class Heal implements CommandExecutor
{
    String pl_name = ChatColor.translateAlternateColorCodes('&', "&7[&bZinc&7]&a ");

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        if (sender instanceof Player player)
        {
            if (player.isOp())
            {
                if (args.length == 0)
                {
                    player.sendMessage(pl_name + "İyileştirildiniz ve açlığınız yenilendi.");
                    player.setHealth(20.0);
                    player.setFoodLevel(20);
                    player.setFireTicks(0);
                }
                else if (args.length == 1)
                {
                    boolean is_online = false;

                    for (Player p : Bukkit.getOnlinePlayers())
                    {
                        if (p.getName().equals(args[0]))
                        {
                            is_online = true;
                            p.sendMessage(pl_name + player.getDisplayName() + " tarafından iyileştirildiniz.");
                            player.sendMessage(pl_name + p.getDisplayName() + " iyileştirildi.");
                            p.setHealth(20.0);
                            p.setFoodLevel(20);
                            p.setFireTicks(0);
                            break;
                        }
                    }

                    if (!is_online) player.sendMessage(pl_name + "Oyuncu bulunamadı.");
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
