package yuta.koujousen;

import Command.readyTimer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.*;
import org.jetbrains.annotations.NotNull;
import yuta.koujousen.Listener.Coreset;
import yuta.koujousen.Listener.Startitem;

public final class Koujousen extends JavaPlugin {
    public static int redcount;
    public static int bluecount;
    public static JavaPlugin plugin;
    public static Scoreboard corenumber;
    public static Score rednumber;
    public static Score bluenumber;
    public static ScoreboardManager manager;
    public static Objective mainObject;
    public static Team Red;
    public static Team Blue;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new Coreset(), this);
        getServer().getPluginManager().registerEvents(new Startitem(),this);
        manager = Bukkit.getScoreboardManager();
        corenumber = manager.getMainScoreboard();
        Red = corenumber.getTeam("red");
        Blue = corenumber.getTeam("blue");
        mainObject = corenumber.registerNewObjective("battlecastle", "dummy");
        mainObject.setDisplayName(ChatColor.GOLD + "Core");
        rednumber = mainObject.getScore(ChatColor.RED + "redcore:");
        bluenumber = mainObject.getScore(ChatColor.AQUA + "bluecore:");
        redcount= getConfig().getInt("redcount");
        bluecount = getConfig().getInt("bluecount");
        this.getCommand("starttimer").setExecutor(new readyTimer());
        if (Red == null) {
            Red = corenumber.registerNewTeam("red");
            Red.setPrefix(ChatColor.RED + "[RED] ");
            Red.setSuffix(ChatColor.RESET.toString());
            Red.setDisplayName("red");
            Red.setColor(ChatColor.RED);
            Red.setAllowFriendlyFire(false);
        }

        if (Blue == null) {
            Blue = corenumber.registerNewTeam("blue");
            Blue.setPrefix(ChatColor.BLUE + "[BLUE] ");
            Blue.setSuffix(ChatColor.RESET.toString());
            Blue.setDisplayName("blue");
            Blue.setColor(ChatColor.BLUE);
            Blue.setAllowFriendlyFire(false);
        }
        mainObject.setDisplaySlot(DisplaySlot.SIDEBAR);
        plugin = this;
        super.onEnable();
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        mainObject.unregister();
        getConfig().set("redcount", redcount);
        getConfig().set("bluecount", bluecount);
        saveConfig();
        super.onDisable();
        // Plugin shutdown logic
    }

    public static @NotNull Plugin getPlugin() {return plugin;}
}

