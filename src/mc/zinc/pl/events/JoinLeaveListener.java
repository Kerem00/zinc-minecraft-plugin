package mc.zinc.pl.events;

import mc.zinc.pl.Simple;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scoreboard.*;

public class JoinLeaveListener implements Listener
{
    String pl_name = ChatColor.translateAlternateColorCodes('&', "&7[&bZinc&7]&a ");

    private static void update_scoreboard(boolean left)
    {
        for (Player p : Bukkit.getOnlinePlayers())
        {
            Score nick;
            Score rank;
            ScoreboardManager m = Bukkit.getScoreboardManager();
            Scoreboard b = m.getNewScoreboard();
            Objective o = b.registerNewObjective("Scoreboard", "scores", ChatColor.translateAlternateColorCodes('&', "&7[&bZinc&7]&a "));
            o.setDisplaySlot(DisplaySlot.SIDEBAR);
            if (p.isOp())
            {
                nick = o.getScore(ChatColor.GRAY + "Nickname: " + ChatColor.DARK_RED + p.getName());
                rank = o.getScore(ChatColor.GRAY + "Rank: " + ChatColor.RED + "Owner");
            }
            else if (Simple.is_vip(p.getName()))
            {
                nick = o.getScore(ChatColor.GRAY + "Nickname: " + ChatColor.YELLOW + p.getName());
                rank = o.getScore(ChatColor.GRAY + "Rank: " + ChatColor.DARK_PURPLE + "VIP");
            }
            else
            {
                nick = o.getScore(ChatColor.GRAY + "Nickname: " + ChatColor.AQUA + p.getName());
                rank = o.getScore(ChatColor.GRAY + "Rank: " + ChatColor.DARK_AQUA + "Player");
            }
            Score space = o.getScore("");
            Score second_space = o.getScore(" ");
            Score your_info = o.getScore(ChatColor.translateAlternateColorCodes('&', "&eYour Info:"));
            Score server_info = o.getScore(ChatColor.translateAlternateColorCodes('&', "&eServer Info:"));
            int online = Bukkit.getOnlinePlayers().size();
            Score online_count = o.getScore(ChatColor.GREEN + "Online: " + ((left) ? online - 1 : online));
            space.setScore(6);
            your_info.setScore(5);
            nick.setScore(4);
            rank.setScore(3);
            second_space.setScore(2);
            server_info.setScore(1);
            online_count.setScore(0);
            p.setScoreboard(b);
        }
    }
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
        update_scoreboard(false);
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent event)
    {
        Player player = event.getPlayer();
        event.setQuitMessage(pl_name + player.getDisplayName() + ChatColor.AQUA + " has left.");
        update_scoreboard(true);
    }
}
