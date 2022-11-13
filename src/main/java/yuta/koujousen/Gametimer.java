//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package yuta.koujousen;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class Gametimer extends JavaPlugin {
    public static int game=10;
    private static int minute;
    private static int secound;
    public static void countdown() {
        BukkitRunnable task = new BukkitRunnable() {
            public void run() {
                secound = game % 60;
                minute = (game - secound) / 60;

                Bukkit.getOnlinePlayers().forEach((player) -> {
                    player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.GREEN + "ゲーム終了まで" +
                            ChatColor.AQUA + String.valueOf(minute) +
                            ChatColor.GREEN + "分" + ChatColor.AQUA +
                            String.valueOf(secound) + ChatColor.GREEN + "秒"));
                });
                if (game == 0) {
                    Bukkit.getOnlinePlayers().forEach((player) -> {
                        player.sendTitle(ChatColor.RED + "終了", "");
                        player.playSound(player, Sound.ENTITY_ENDER_DRAGON_DEATH, 1.0F, 1.0F);
                    });
                    this.cancel();
                }
                game--;
            }
            };

        task.runTaskTimer(Koujousen.getPlugin(), 0L, 20L);
    }
}
