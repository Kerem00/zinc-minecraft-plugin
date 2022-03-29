package mc.zinc.pl.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class BreakPlaceListener implements Listener
{
    @EventHandler
    public void onBreak(BlockBreakEvent event)
    {
        if (!event.getPlayer().isOp())
        {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent event)
    {
        if (!event.getPlayer().isOp())
        {
            event.setCancelled(true);
        }
    }
}
