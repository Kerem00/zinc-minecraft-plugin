package mc.zinc.pl.events;

import mc.zinc.pl.Simple;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinLeaveListener implements Listener
{
    String pl_name = ChatColor.translateAlternateColorCodes('&', "&7[&bZinc&7]&a ");

    @EventHandler
    public void onJoin(PlayerJoinEvent event)
    {
        if (event.getPlayer().getName().contains(" ")) event.getPlayer().kickPlayer("Lütfen isminizde boşluk karakteri kullanmayınız!");

        if (!event.getPlayer().hasPlayedBefore())
        {
            Simple.createNew(event.getPlayer().getName());
        }
    }
}
