package mc.zinc.pl.events;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeathListener implements Listener
{
    String pl_name = ChatColor.translateAlternateColorCodes('&', "&7[&bZinc&7]&a ");

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event)
    {
        Location loc = event.getEntity().getPlayer().getLocation();
        event.getEntity().getPlayer().sendMessage(pl_name + "Last location: " + loc.getBlockX() + ", " + loc.getBlockY() + ", " + loc.getBlockZ() + ".");
    }
}
