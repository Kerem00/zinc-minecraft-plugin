package mc.zinc.pl.events;

import mc.zinc.pl.Simple;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinLeaveListener implements Listener
{
    String pl_name = ChatColor.translateAlternateColorCodes('&', "&7[&bZinc&7]&a ");

    @EventHandler
    public void onJoin(PlayerJoinEvent event)
    {
        Player player = event.getPlayer();

        if (player.getName().contains(" ")) event.getPlayer().kickPlayer("Please don't use space character in your name!");

        if (!player.hasPlayedBefore()) Simple.createNew(event.getPlayer().getName());

        String display_name = "";
        if (player.isOp())
            display_name = ChatColor.translateAlternateColorCodes('&', "&7[&cOwner&7] &4") + player.getName() + ChatColor.GRAY;
        else if (Simple.is_vip(player.getName()))
            display_name = ChatColor.translateAlternateColorCodes('&', "&7[&6VIP&7] &6") + player.getName() + ChatColor.GRAY;
        else
            display_name = ChatColor.DARK_AQUA + player.getName() + ChatColor.GRAY;

        player.setDisplayName(display_name);
        player.setPlayerListName(display_name);
        event.setJoinMessage(pl_name + player.getDisplayName() + ChatColor.AQUA + " has joined.");
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent event)
    {
        Player player = event.getPlayer();
        event.setQuitMessage(pl_name + player.getDisplayName() + ChatColor.AQUA + " has left.");
    }
}
