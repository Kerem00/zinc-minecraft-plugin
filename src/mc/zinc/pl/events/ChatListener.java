package mc.zinc.pl.events;

import mc.zinc.pl.Simple;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener
{
    @EventHandler
    public void onChat(AsyncPlayerChatEvent event)
    {
        event.setFormat(event.getPlayer().getDisplayName() + " " + Simple.get_cc(event.getPlayer().getName()) + event.getMessage());
    }
}
