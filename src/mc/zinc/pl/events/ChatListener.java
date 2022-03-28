package mc.zinc.pl.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener
{
    @EventHandler
    public void onChat(AsyncPlayerChatEvent event)
    {
        event.setFormat(event.getPlayer().getDisplayName() + " " + event.getMessage());
    }
}
