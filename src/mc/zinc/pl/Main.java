//   Zinc - Minecraft plugin for server moderation. 
//   Copyright (C) 2022  Kerem Biçen

//   This program is free software: you can redistribute it and/or modify
//   it under the terms of the GNU General Public License as published by
//   the Free Software Foundation, either version 3 of the License, or
//   (at your option) any later version.

//   This program is distributed in the hope that it will be useful,
//   but WITHOUT ANY WARRANTY; without even the implied warranty of
//   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//   GNU General Public License for more details.

//   You should have received a copy of the GNU General Public License
//   along with this program.  If not, see <https://www.gnu.org/licenses/>.

package mc.zinc.pl;


import mc.zinc.pl.commands.ChatClear;
import mc.zinc.pl.commands.Heal;
import mc.zinc.pl.events.JoinLeaveListener;
import mc.zinc.pl.events.PlayerDeathListener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class Main extends JavaPlugin
{
    String pl_name = ChatColor.translateAlternateColorCodes('&', "&7[&bZinc&7]&a ");

    public void onEnable()
    {
        File dir = new File("plugins/Zinc");
        if (!dir.exists()) dir.mkdir();

        ConsoleCommandSender console = Bukkit.getConsoleSender();
        console.sendMessage(pl_name + "Loading...");
        PluginManager pm = Bukkit.getPluginManager();

        this.getCommand("heal").setExecutor(new Heal());
        this.getCommand("clearchat").setExecutor(new ChatClear());

        pm.registerEvents(new JoinLeaveListener(), this);
        pm.registerEvents(new PlayerDeathListener(), this);

        console.sendMessage(pl_name + "Enabled.");
    }

    public void onDisable()
    {
        ConsoleCommandSender console = Bukkit.getConsoleSender();
        console.sendMessage(pl_name + "Disabled.");
    }
}
